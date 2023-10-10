package async.wrapper;

import async.callback.DefaultCallback;
import async.callback.ICallback;
import async.callback.IWorker;
import async.exception.SkippedException;
import async.executor.timer.SystemClock;
import async.worker.DependWrapper;
import async.worker.ResultState;
import async.worker.WorkResult;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

/**
 * 对每个任务单元 worker 和回调 callback 进行封装，是一个最小的调度单元<br>
 * 客户端通过编排 wrapper 之间的关系，达到组合各个 worker 顺序的目的
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
@Slf4j
public class WorkerWrapper<T, V> {
  /** 当前 wrapper 的唯一标识 */
  private String id;

  /** worker 需要处理的参数 */
  private T param;

  private IWorker<T, V> worker;
  private ICallback<T, V> callback;

  /** 当前 wrapper 的下一个 wrapper, 为空说明自己就是最后一个；有一个说明是串行；多个就是并行，有几个就需要开几个线程 */
  private List<WorkerWrapper<?, ?>> nextWrappers;
  /**
   * 依赖的 wrappers, 有两种情况：<br>
   * 1: 必须依赖的全部完成后，才能够执行自己<br>
   * 2: 依赖的任何一个、多个完成之后，才能够执行自己<br>
   * 可以通过 must 字段来控制依赖项是否必须完成
   */
  private List<DependWrapper> dependWrappers;
  /**
   * 标记该事件是否已经被处理过了，例如：任务已经超时返回 false 了，后续 rpc 又收到返回值了，此时不再进行二次调用<br>
   * 0-init, 1-finish, 2-error, 3-working
   */
  private AtomicInteger state = new AtomicInteger(0);

  /**
   * 是否在执行自己前，去校验nextWrapper的执行结果<br>
   * A -> B <br>
   * -------> D <br>
   * ---C <br>
   * 例如在这种情况下，A,B 串行并且与 C 并行，两条任务线任意一个执行完就可以执行 D, <br>
   * 如果执行 B 的时候发现 D 已经被执行了（C执行完之后触发）, 那么 B 就不需要再执行了
   *
   * <p>注意，该属性仅在nextWrapper数量<=1时有效，>1时的情况是不存在的
   */
  private volatile boolean needCheckNextWrapperResult;
  /** 存储任务结果，worker 中 action 方法的返回值会赋值给它，在 result 回调中可以拿到这个结果 */
  private volatile WorkResult<V> workResult = WorkResult.defaultResult();
  /** 收集所有的 wrapper ，key 是 id，以便用于在 worker 工作单元中，获取任意 worker 的执行结果 */
  private Map<String, WorkerWrapper> fromParamUseWrappers;

  private static final int INIT = 0;
  private static final int FINISH = 1;
  private static final int ERROR = 2;
  private static final int WORKING = 3;

  private WorkerWrapper(String id, IWorker<T, V> worker, T param, ICallback<T, V> callback) {
    if (worker == null) {
      throw new NullPointerException("async.worker is null");
    }
    this.worker = worker;
    this.param = param;
    this.id = id;
    // 允许不设置回调，添加默认回调
    if (callback == null) {
      callback = new DefaultCallback<>();
    }
    this.callback = callback;
  }

  /**
   * 开始执行
   *
   * @param poolExecutor
   * @param fromWrapper 当前 work 是由上游哪个 wrapper 发起的
   * @param remainTime 剩余时间，用来监控任务超时的。随着一组任务的执行，<br>
   *     这个值从全局设置的 timeout 时间逐渐减少，当 remainTime <=0 时，任务就超时了
   */
  private void work(
      ExecutorService executorService,
      WorkerWrapper fromWrapper,
      long remainTime,
      Map<String, WorkerWrapper> forParamUseWrappers) {
    this.fromParamUseWrappers = forParamUseWrappers;
    // 1. 收集所有的 wrapper，key 是 id, 以便在 worker 工作单元中，获取任意 worker 的执行结果
    fromParamUseWrappers.put(id, this);
    long now = SystemClock.now();
    // 2. 总时间已经超时，快速失败，进行下一个
    if (remainTime <= 0) {
      fastFail(INIT, null);
      beginNext(executorService, now, remainTime);
      return;
    }
    // 3. 自己已经执行过了，直接执行下一个，不再重复执行
    // 可能有多个依赖，其中的一个依赖已经执行完了，并且自己也已开始执行或执行完毕。当另一个依赖执行完毕，又进来该方法时，就不重复处理了
    if (getState() == FINISH || getState() == ERROR) {
      beginNext(executorService, now, remainTime);
      return;
    }
    // 4. 如果在执行前需要校验nextWrapper的状态, 仅在 nextWrappers <= 1 时有效
    if (needCheckNextWrapperResult) {
      // 如果自己的next链上有已经出结果或已经开始执行的任务了，自己就不用继续了
      if (!checkNextWrapperResult()) {
        fastFail(INIT, new SkippedException());
        beginNext(executorService, now, remainTime);
        return;
      }
    }
    // 5. 如果没有任何依赖，说明自己就是第一批执行的
    if (dependWrappers == null || dependWrappers.size() == 0) {
      // 5.1 执行当前任务
      fire();
      // 5.2 执行后续任务
      beginNext(executorService, now, remainTime);
      return;
    }
    // 前方有依赖
    // 1. 只有一个依赖 A -> B
    // 2. 有多个依赖 A, C -> B (需要 A, C 都完成了才能执行 B, 但 A 和 C 执行完之后都会去唤醒 B)
    // 所以 B 需要做判断,必须 A, C 都完成之后自己才能执行
    // 6. 处理有前置依赖的情况
    if (dependWrappers.size() == 1) {
      // 6.1 只有一个前置依赖，依赖任务正常结束了，就执行自己
      doDependsOneJob(executorService, fromWrapper, remainTime);
      beginNext(executorService, now, remainTime);
      return;
    } else {
      // 6.2 有多个前置依赖，多个依赖任务的判断处理
      doDependsOneJobs(executorService, dependWrappers, fromWrapper, now, remainTime);
    }
  }

  public void work(
      ExecutorService executorService,
      long remainTime,
      Map<String, WorkerWrapper> forParamUseWrappers) {
    work(executorService, null, remainTime, forParamUseWrappers);
  }

  /** 总控制台超时，停止所有任务 */
  public void stopNow() {
    if (getState() == INIT || getState() == WORKING) {
      fastFail(getState(), null);
    }
  }

  private boolean checkNextWrapperResult() {
    // 如果自己就是最后一个，或者后面有并行的多个，就返回true
    if (nextWrappers == null || nextWrappers.size() != 1) {
      return getState() == INIT;
    }
    WorkerWrapper nextWrapper = nextWrappers.get(0);
    boolean state = nextWrapper.getState() == INIT;
    // 继续校验自己的next的状态
    return state && nextWrapper.checkNextWrapperResult();
  }

  private void beginNext(ExecutorService executorService, long now, long remainTime) {
    // 已经花费的时间
    long costTime = SystemClock.now() - now;
    // 1. 后续没有任务了，直接返回
    if (nextWrappers == null) {
      return;
    }
    // 2. 后续只有一个任务，使用当前任务的线程执行 next 任务
    if (nextWrappers.size() == 1) {
      nextWrappers
          .get(0)
          .work(executorService, WorkerWrapper.this, remainTime - costTime, fromParamUseWrappers);
      return;
    }
    // 3. 后续有多个任务，使用 CompletableFuture[] 包装，有几个任务就起几个线程
    CompletableFuture[] futures = new CompletableFuture[nextWrappers.size()];
    for (int i = 0; i < nextWrappers.size(); i++) {
      int finalI = i;
      futures[i] =
          CompletableFuture.runAsync(
              () ->
                  nextWrappers
                      .get(finalI)
                      .work(
                          executorService,
                          WorkerWrapper.this,
                          remainTime - costTime,
                          fromParamUseWrappers),
              executorService);
    }
    // 4. 阻塞获取 Future 结果，这里没有超时时间，超时时间由全局统一控制
    try {
      CompletableFuture.allOf(futures).get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  private void doDependsOneJob(
      ExecutorService executorService, WorkerWrapper dependWrapper, long remainTime) {
    if (ResultState.TIMEOUT == dependWrapper.getWorkResult().getResultState()) {
      // 依赖超时
      workResult = defaultResult();
      fastFail(INIT, null);
    } else if (ResultState.EXCEPTION == dependWrapper.getWorkResult().getResultState()) {
      // 依赖异常
      workResult = defaultExResult(dependWrapper.getWorkResult().getEx());
      fastFail(INIT, null);
    } else {
      // 依赖的任务正常执行完毕，执行自己
      fire();
    }
  }

  private synchronized void doDependsOneJobs(
      ExecutorService executorService,
      List<DependWrapper> dependWrappers,
      WorkerWrapper fromWrapper,
      long now,
      long remainTime) {
    // 如果当前任务已经完成了，依赖的其他任务拿到锁再进来时，不需要执行下面的逻辑了
    if (getState() != INIT) {
      return;
    }
    // 如果当前依赖不是非必须的，就跳过不处理
    boolean nowDependIsMust = false;
    // 必须完成的上游 wrapper 集合
    Set<DependWrapper> mustWrapper = new HashSet<>();
    for (DependWrapper dependWrapper : dependWrappers) {
      if (dependWrapper.isMust()) {
        mustWrapper.add(dependWrapper);
      }
      if (dependWrapper.getDependWrapper().equals(fromWrapper)) {
        nowDependIsMust = dependWrapper.isMust();
      }
    }
    // 1. 如果全部不是必须的，只要执行到了这里，就直接执行自己
    if (mustWrapper.size() == 0) {
      // 超时处理
      if (ResultState.TIMEOUT == fromWrapper.getWorkResult().getResultState()) {
        fastFail(INIT, null);
      } else {
        // 正常情况执行
        fire();
      }
      beginNext(executorService, now, remainTime);
      return;
    }
    // 2. 如果当前依赖是非必须的，则跳过不处理（非 must 的情况）
    if (!nowDependIsMust) {
      return;
    }
    // 如果 fromWrapper 是必须的
    boolean existNoFinish = false;
    boolean hasError = false;
    // 先判断前面必须执行的依赖的结果，如果有任何一个失败，那就直接给自己设置成失败，进行下一步
    for (DependWrapper dependWrapper : mustWrapper) {
      WorkerWrapper workerWrapper = dependWrapper.getDependWrapper();
      WorkResult tempWorkResult = workerWrapper.getWorkResult();
      // 结果为空或者状态是 working, 说明依赖任务还没执行到或没执行完
      if (tempWorkResult == null || workerWrapper.getState() == WORKING) {
        existNoFinish = true;
        break;
      }
      if (tempWorkResult.getResultState() == ResultState.TIMEOUT) {
        workResult = defaultResult();
        hasError = true;
        break;
      }
      if (tempWorkResult.getResultState() == ResultState.EXCEPTION) {
        workResult = defaultExResult(workerWrapper.getWorkResult().getEx());
        hasError = true;
        break;
      }
    }
    // 3. 有失败的
    if (hasError) {
      fastFail(INIT, null);
      beginNext(executorService, now, remainTime);
      return;
    }
    // 如果上游都没有失败
    // 1. 都 finish 了
    // 2. 还有在 working 的
    if (!existNoFinish) {
      // 上游都 finish 了，直接执行自己
      fire();
      beginNext(executorService, now, remainTime);
      return;
    }
  }

  /**
   * 执行自己的 job
   *
   * @param poolExecutor
   * @param workerTimeout
   */
  private void fire() {
    // 阻塞获取结果
    workResult = workerDoJob();
  }

  private boolean fastFail(int expect, Exception e) {
    // 将状态从 expect 状态，修改为 error
    if (!compareAndSetState(expect, ERROR)) {
      log.info("compareAndSetState----------fail");
      return false;
    }
    // 处理没有完成的任务
    if (checkIsNullResult()) {
      if (e == null) {
        workResult = defaultResult();
      } else {
        workResult = defaultExResult(e);
      }
    }
    // 回调 result
    callback.result(false, getParam(), workResult);
    return true;
  }

  /**
   * 具体单个 worker 执行逻辑
   *
   * @return
   */
  private WorkResult<V> workerDoJob() {
    // 1. Check 重复执行
    if (!checkIsNullResult()) {
      // 已经执行过了，避免重复执行
      return workResult;
    }
    try {
      // 2. 设置 wrapper 状态为 working
      // 任务不是 INIT 状态，无需执行 (说明正在执行或已执行完毕)
      if (!compareAndSetState(INIT, WORKING)) {
        return workResult;
      }
      // 3. 回调 begin
      callback.begin();
      // 4. 执行任务具体的耗时操作
      V resultValue = worker.action(getParam(), fromParamUseWrappers);
      // 5. 设置 wrapper 状态为 finish
      // 状态不是 working, 说明在其它地方已经执行了
      if (!compareAndSetState(WORKING, FINISH)) {
        return workResult;
      }
      workResult.setResultState(ResultState.SUCCESS);
      workResult.setResult(resultValue);
      // 6. 执行回调
      callback.result(true, getParam(), workResult);
      return workResult;
    } catch (Exception e) {
      // 7. 异常处理
      fastFail(WORKING, e);
      return workResult;
    }
  }

  public void addNext(WorkerWrapper<?, ?> workerWrapper) {
    if (nextWrappers == null) {
      nextWrappers = new ArrayList<>();
    }
    // 避免重复添加
    for (WorkerWrapper<?, ?> nextWrapper : nextWrappers) {
      if (workerWrapper.equals(nextWrapper)) {
        return;
      }
    }
    nextWrappers.add(workerWrapper);
  }

  private boolean checkIsNullResult() {
    return ResultState.DEFAULT == workResult.getResultState();
  }

  private void addDepend(WorkerWrapper<?, ?> workerWrapper, boolean must) {
    this.addDepend(new DependWrapper(workerWrapper, must));
  }

  private void addDepend(DependWrapper dependWrapper) {
    if (dependWrappers == null) {
      dependWrappers = new ArrayList<>();
    }
    // 如果依赖有重复，则不继续添加
    for (DependWrapper wrapper : dependWrappers) {
      if (wrapper.equals(dependWrapper)) {
        return;
      }
    }
    dependWrappers.add(dependWrapper);
  }

  private WorkResult<V> defaultResult() {
    return new WorkResult<>(getWorker().defaultValue(), ResultState.TIMEOUT);
  }

  private WorkResult<V> defaultExResult(Exception ex) {
    return new WorkResult<>(getWorker().defaultValue(), ResultState.EXCEPTION, ex);
  }

  public T getParam() {
    return param;
  }

  public IWorker<T, V> getWorker() {
    return worker;
  }

  public ICallback<T, V> getCallback() {
    return callback;
  }

  public List<WorkerWrapper<?, ?>> getNextWrappers() {
    return nextWrappers;
  }

  public void setNextWrappers(List<WorkerWrapper<?, ?>> nextWrappers) {
    this.nextWrappers = nextWrappers;
  }

  public List<DependWrapper> getDependWrappers() {
    return dependWrappers;
  }

  public void setDependWrappers(List<DependWrapper> dependWrappers) {
    this.dependWrappers = dependWrappers;
  }

  public int getState() {
    return state.get();
  }

  public boolean compareAndSetState(int expect, int update) {
    return this.state.compareAndSet(expect, update);
  }

  public WorkResult<V> getWorkResult() {
    return workResult;
  }

  public void setWorkResult(WorkResult<V> workResult) {
    this.workResult = workResult;
  }

  private void setNeedCheckNextWrapperResult(boolean needCheckNextWrapperResult) {
    this.needCheckNextWrapperResult = needCheckNextWrapperResult;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        param,
        worker,
        callback,
        nextWrappers,
        dependWrappers,
        state,
        workResult,
        needCheckNextWrapperResult);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    WorkerWrapper<?, ?> wrapper = (WorkerWrapper<?, ?>) obj;
    return needCheckNextWrapperResult == wrapper.needCheckNextWrapperResult
        && Objects.equals(param, wrapper.param)
        && Objects.equals(worker, wrapper.worker)
        && Objects.equals(callback, wrapper.callback)
        && Objects.equals(nextWrappers, wrapper.nextWrappers)
        && Objects.equals(dependWrappers, wrapper.dependWrappers)
        && Objects.equals(state, wrapper.state)
        && Objects.equals(workResult, wrapper.workResult);
  }

  public static class Builder<W, C> {
    /** wrapper 的唯一标识 */
    private String id = UUID.randomUUID().toString();
    /** worker 要处理的参数 */
    private W param;

    private IWorker<W, C> worker;
    private ICallback<W, C> callback;
    /** 当前 wrapper 的后续所有 wrapper */
    private List<WorkerWrapper<?, ?>> nextWrappers;
    /** 当前 wrapper 依赖的所有 wrapper */
    private List<DependWrapper> dependWrappers;
    /** 强依赖于当前 wrapper 的集合 */
    private Set<WorkerWrapper<?, ?>> selfIsMustSet;

    private boolean needCheckNextWrapperResult = true;

    public Builder<W, C> worker(IWorker<W, C> worker) {
      this.worker = worker;
      return this;
    }

    public Builder<W, C> param(W w) {
      this.param = w;
      return this;
    }

    public Builder<W, C> id(String id) {
      if (id != null) {
        this.id = id;
      }
      return this;
    }

    public Builder<W, C> needCheckNextWrapperResult(boolean needCheckNextWrapperResult) {
      this.needCheckNextWrapperResult = needCheckNextWrapperResult;
      return this;
    }

    public Builder<W, C> callback(ICallback<W, C> callback) {
      this.callback = callback;
      return this;
    }

    public Builder<W, C> depend(WorkerWrapper<?, ?>... wrappers) {
      if (wrappers == null) {
        return this;
      }
      for (WorkerWrapper<?, ?> wrapper : wrappers) {
        depend(wrapper);
      }
      return this;
    }

    public Builder<W, C> depend(WorkerWrapper<?, ?> wrapper) {
      return depend(wrapper, true);
    }

    public Builder<W, C> depend(WorkerWrapper<?, ?> wrapper, boolean isMust) {
      if (wrapper == null) {
        return this;
      }
      DependWrapper dependWrapper = new DependWrapper(wrapper, isMust);
      if (dependWrappers == null) {
        dependWrappers = new ArrayList<>();
      }
      dependWrappers.add(dependWrapper);
      return this;
    }

    public Builder<W, C> next(WorkerWrapper<?, ?> wrapper) {
      return next(wrapper, true);
    }

    public Builder<W, C> next(WorkerWrapper<?, ?>... wrappers) {
      if (wrappers == null) {
        return this;
      }
      for (WorkerWrapper<?, ?> wrapper : wrappers) {
        next(wrapper);
      }
      return this;
    }

    public Builder<W, C> next(WorkerWrapper<?, ?> wrapper, boolean selfIsMust) {
      if (nextWrappers == null) {
        nextWrappers = new ArrayList<>();
      }
      nextWrappers.add(wrapper);
      if (selfIsMust) {
        if (selfIsMustSet == null) {
          selfIsMustSet = new HashSet<>();
        }
        selfIsMustSet.add(wrapper);
      }
      return this;
    }

    public WorkerWrapper<W, C> build() {
      // 创建 WorkerWrapper
      WorkerWrapper<W, C> wrapper = new WorkerWrapper<>(id, worker, param, callback);
      wrapper.setNeedCheckNextWrapperResult(needCheckNextWrapperResult);
      // 添加前置依赖
      if (dependWrappers != null) {
        for (DependWrapper dependWrapper : dependWrappers) {
          dependWrapper.getDependWrapper().addNext(wrapper);
          wrapper.addDepend(dependWrapper);
        }
      }
      // 添加后置依赖
      if (nextWrappers != null) {
        for (WorkerWrapper<?, ?> nextWrapper : nextWrappers) {
          boolean must = false;
          if (selfIsMustSet != null && selfIsMustSet.contains(nextWrapper)) {
            must = true;
          }
          // 后置任务的前置依赖就是自己
          nextWrapper.addDepend(wrapper, must);
          wrapper.addNext(nextWrapper);
        }
      }
      return wrapper;
    }
  }
}
