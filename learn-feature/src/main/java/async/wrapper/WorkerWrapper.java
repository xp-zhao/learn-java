package async.wrapper;

import async.callback.DefaultCallback;
import async.callback.ICallback;
import async.callback.IWorker;
import async.executor.timer.SystemClock;
import async.worker.DependWrapper;
import async.worker.ResultState;
import async.worker.WorkResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  /** 存储临时结果 */
  private volatile WorkResult<V> workResult;

  private static final int FINISH = 1;
  private static final int ERROR = 2;
  private static final int WORKING = 3;
  private static final int INIT = 0;

  public WorkerWrapper(IWorker<T, V> worker, T param, ICallback<T, V> callback) {
    if (worker == null) {
      throw new NullPointerException("async.worker is null");
    }
    this.worker = worker;
    this.param = param;
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
  private void work(ThreadPoolExecutor poolExecutor, WorkerWrapper fromWrapper, long remainTime) {
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

  public void work(ThreadPoolExecutor poolExecutor, long remainTime) {
    work(poolExecutor, null, remainTime);
  }

  private void beginNext(ThreadPoolExecutor poolExecutor, long now, long remainTime) {
    // 已经花费的时间
    long costTime = SystemClock.now() - now;
    if (nextWrappers == null) {
      return;
    }
    if (nextWrappers.size() == 1) {
      nextWrappers.get(0).work(poolExecutor, WorkerWrapper.this, remainTime - costTime);
      return;
    }
    CompletableFuture[] futures = new CompletableFuture[nextWrappers.size()];
    for (int i = 0; i < nextWrappers.size(); i++) {
      int finalI = i;
      CompletableFuture.runAsync(
          () ->
              nextWrappers
                  .get(finalI)
                  .work(poolExecutor, WorkerWrapper.this, remainTime - costTime),
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
      V resultValue = worker.action(getParam());
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

  public WorkerWrapper addNext(WorkerWrapper<?, ?>... nextWrappers) {
    if (nextWrappers == null) {
      return this;
    }
    for (WorkerWrapper<?, ?> workerWrapper : nextWrappers) {
      addNext(workerWrapper);
    }
    return this;
  }

  public WorkerWrapper addNext(IWorker<T, V> worker, T param, ICallback<T, V> callback) {
    WorkerWrapper<T, V> workerWrapper = new WorkerWrapper<>(worker, param, callback);
    return addNext(workerWrapper);
  }

  public WorkerWrapper addNext(WorkerWrapper<?, ?> workerWrapper) {
    if (nextWrappers == null) {
      nextWrappers = new ArrayList<>();
    }
    nextWrappers.add(workerWrapper);
    workerWrapper.addDepend(this);
    return this;
  }

  private void addDepend(WorkerWrapper<?, ?> workerWrapper) {
    this.addDepend(workerWrapper, true);
  }

  private void addDepend(WorkerWrapper<?, ?> workerWrapper, boolean must) {
    if (dependWrappers == null) {
      dependWrappers = new ArrayList<>();
    }
    dependWrappers.add(new DependWrapper(workerWrapper, must));
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
}
