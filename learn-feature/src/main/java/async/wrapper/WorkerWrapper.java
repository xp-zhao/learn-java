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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 对每个 worker 和 callback 进行封装
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
public class WorkerWrapper<T, V> {
  /** 当前 wrapper 的唯一标识 */
  private String id;

  /** worker 需要处理的参数 */
  private T param;

  private IWorker<T, V> worker;
  private ICallback<T, V> callback;

  /** 当前 wrapper 的下一个 wrapper, 为空说明自己就是最后一个；有一个说明是串行；多个就是并行，有几个就需要开几个线程 */
  private List<WorkerWrapper<?, ?>> nextWrappers;
  /** 依赖的 wrappers, 必须依赖的全部完成后，才能够执行自己 */
  private List<DependWrapper> dependWrappers;
  /**
   * 标记该事件是否已经被处理过了，例如：任务已经超时返回 false 了，后续 rpc 又收到返回值了，此时不再进行二次调用<br>
   * 1-finish, 2-error, 3-working
   */
  private AtomicInteger state = new AtomicInteger(0);

  /**
   * 是否在执行自己前，去校验nextWrapper的执行结果
   *
   * <p>注意，该属性仅在nextWrapper数量<=1时有效，>1时的情况是不存在的
   */
  private volatile boolean needCheckNextWrapperResult;
  /** 存储临时结果 */
  private volatile WorkResult<V> workResult;
  /** 存放所有 wrapper 的 id 和 wrapper 映射 */
  private Map<String, WorkerWrapper> fromParamUseWrappers;

  private static final int FINISH = 1;
  private static final int ERROR = 2;
  private static final int WORKING = 3;
  private static final int INIT = 0;

  private WorkerWrapper(String id, IWorker<T, V> worker, T param, ICallback<T, V> callback) {
    if (worker == null) {
      throw new NullPointerException("async.worker is null");
    }
    this.worker = worker;
    this.param = param;
    this.id = id;
    // 允许不设置回调
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
   * @param remainTime
   */
  private void work(
      ThreadPoolExecutor poolExecutor,
      WorkerWrapper fromWrapper,
      long remainTime,
      Map<String, WorkerWrapper> forParamUseWrappers) {
    this.fromParamUseWrappers = forParamUseWrappers;
    fromParamUseWrappers.put(id, this);
    long now = SystemClock.now();
    // 总时间已经超时，快速失败，进行下一个
    if (remainTime <= 0) {
      fastFail(INIT, null);
      beginNext(poolExecutor, now, remainTime);
      return;
    }
    // 自己已经执行过了，直接执行下一个，不再重复执行
    if (getState() != INIT) {
      beginNext(poolExecutor, now, remainTime);
      return;
    }
    // 如果在执行前需要校验nextWrapper的状态
    if (needCheckNextWrapperResult) {
      // 如果自己的next链上有已经出结果或已经开始执行的任务了，自己就不用继续了
      if (!checkNextWrapperResult()) {
        fastFail(INIT, new SkippedException());
        beginNext(poolExecutor, now, remainTime);
        return;
      }
    }
    // 如果没有任何依赖，说明自己就是第一批执行的
    if (dependWrappers == null || dependWrappers.size() == 0) {
      fire(poolExecutor, remainTime);
      beginNext(poolExecutor, now, remainTime);
      return;
    }
    // 前方有依赖
    // 1. 只有一个依赖 A -> B
    // 2. 有多个依赖 A, C -> B (需要 A, C 都完成了才能执行 B, 但 A 和 C 执行完之后都会去唤醒 B)
    // 所以 B 需要做判断,必须 A, C 都完成之后自己才能执行
    if (dependWrappers.size() == 1) {
      doDependsOneJob(poolExecutor, fromWrapper, remainTime);
      beginNext(poolExecutor, now, remainTime);
      return;
    }
    doDependsOneJobs(poolExecutor, dependWrappers, fromWrapper, now, remainTime);
  }

  public void work(
      ThreadPoolExecutor poolExecutor,
      long remainTime,
      Map<String, WorkerWrapper> forParamUseWrappers) {
    work(poolExecutor, null, remainTime, forParamUseWrappers);
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

  private void beginNext(ThreadPoolExecutor poolExecutor, long now, long remainTime) {
    // 已经花费的时间
    long costTime = SystemClock.now() - now;
    if (nextWrappers == null) {
      return;
    }
    if (nextWrappers.size() == 1) {
      nextWrappers
          .get(0)
          .work(poolExecutor, WorkerWrapper.this, remainTime - costTime, fromParamUseWrappers);
      return;
    }
    CompletableFuture[] futures = new CompletableFuture[nextWrappers.size()];
    for (int i = 0; i < nextWrappers.size(); i++) {
      int finalI = i;
      CompletableFuture.runAsync(
          () ->
              nextWrappers
                  .get(finalI)
                  .work(
                      poolExecutor,
                      WorkerWrapper.this,
                      remainTime - costTime,
                      fromParamUseWrappers),
          poolExecutor);
    }
    try {
      CompletableFuture.allOf(futures).get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  private void doDependsOneJob(
      ThreadPoolExecutor poolExecutor, WorkerWrapper dependWrapper, long remainTime) {
    if (ResultState.TIMEOUT == dependWrapper.getWorkResult().getResultState()) {
      workResult = defaultResult();
      fastFail(INIT, null);
    } else if (ResultState.EXCEPTION == dependWrapper.getWorkResult().getResultState()) {
      workResult = defaultExResult(dependWrapper.getWorkResult().getEx());
    } else {
      // 依赖的任务正常执行完毕，执行自己
      fire(poolExecutor, remainTime);
    }
  }

  private void doDependsOneJobs(
      ThreadPoolExecutor poolExecutor,
      List<DependWrapper> dependWrappers,
      WorkerWrapper fromWrapper,
      long now,
      long remainTime) {
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
    // 如果全部不是必须的，那么直接执行自己
    if (mustWrapper.size() == 0) {
      if (ResultState.TIMEOUT == fromWrapper.getWorkResult().getResultState()) {
        fastFail(INIT, null);
      } else {
        fire(poolExecutor, remainTime);
      }
      beginNext(poolExecutor, now, remainTime);
      return;
    }
    // 如果存在必须执行的依赖 wrapper， 但 fromWrapper 不是必须的，那就直接什么都不做
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
    if (hasError) {
      fastFail(INIT, null);
      beginNext(poolExecutor, now, remainTime);
      return;
    }
    // 如果上游都没有失败
    // 1. 都 finish 了
    // 2. 还有在 working 的
    if (!existNoFinish) {
      // 上游都 finish 了，直接执行自己
      fire(poolExecutor, remainTime);
      beginNext(poolExecutor, now, remainTime);
      return;
    }
  }

  /**
   * 执行自己的 job
   *
   * @param poolExecutor
   * @param workerTimeout
   */
  private void fire(ThreadPoolExecutor poolExecutor, long workerTimeout) {
    workResult = workerDoJob();
  }

  private boolean fastFail(int expect, Exception e) {
    System.out.println(
        "fastFail:" + Thread.currentThread().getName() + " time " + System.currentTimeMillis());
    // 将状态从 expect 状态，修改为 error
    if (!compareAndSetState(expect, ERROR)) {
      System.out.println("compareAndSetState----------fail");
      return false;
    }
    if (workResult == null) {
      if (e == null) {
        workResult = defaultResult();
      } else {
        workResult = defaultExResult(e);
      }
    }
    callback.result(false, getParam(), workResult);
    return true;
  }

  /**
   * 具体单个 worker 执行逻辑
   *
   * @return
   */
  private WorkResult<V> workerDoJob() {
    if (workResult != null) {
      // 已经执行过了，避免重复执行
      return workResult;
    }
    try {
      // 任务不是 INIT 状态，无需执行
      if (!compareAndSetState(INIT, WORKING)) {
        return workResult;
      }
      callback.begin();
      // 执行任务的具体操作
      V resultValue = worker.action(getParam(), fromParamUseWrappers);
      WorkResult<V> tempResult = new WorkResult<>(resultValue, ResultState.SUCCESS);
      // 状态不是 working, 说明在其它地方已经执行了
      if (!compareAndSetState(WORKING, FINISH)) {
        return workResult;
      }
      // 执行回调
      callback.result(true, getParam(), tempResult);
      workResult = tempResult;
      return workResult;
    } catch (Exception e) {
      if (workResult != null) {
        return workResult;
      }
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
      WorkerWrapper<W, C> wrapper = new WorkerWrapper<>(id, worker, param, callback);
      wrapper.setNeedCheckNextWrapperResult(needCheckNextWrapperResult);
      if (dependWrappers != null) {
        for (DependWrapper dependWrapper : dependWrappers) {
          dependWrapper.getDependWrapper().addNext(wrapper);
          wrapper.addDepend(dependWrapper);
        }
      }
      if (nextWrappers != null) {
        for (WorkerWrapper<?, ?> nextWrapper : nextWrappers) {
          boolean must = false;
          if (selfIsMustSet != null && selfIsMustSet.contains(nextWrapper)) {
            must = true;
          }
          nextWrapper.addDepend(wrapper, must);
          wrapper.addNext(nextWrapper);
        }
      }
      return wrapper;
    }
  }
}
