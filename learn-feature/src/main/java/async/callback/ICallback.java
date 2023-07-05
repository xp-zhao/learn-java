package async.callback;

import async.worker.WorkResult;

/**
 * 回调接口，每个执行单元执行完毕之后，会调用该接口
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
public interface ICallback<T, V> {
  /** 任务开始的监听 */
  default void begin() {}

  /**
   * 任务执行结束之后调用
   *
   * @param success
   * @param param
   * @param workResult
   */
  void result(boolean success, T param, WorkResult<V> workResult);
}
