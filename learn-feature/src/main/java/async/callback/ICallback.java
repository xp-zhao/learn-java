package async.callback;

import async.worker.WorkResult;

/**
 * 回调接口，每个执行单元执行前调用 begin，执行后调用 result
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
@FunctionalInterface
public interface ICallback<T, V> {
  /** 任务开始的监听 */
  default void begin() {}

  /**
   * 任务执行结束之后调用, 带有执行成功，失败，原始入参和详细的结果
   *
   * @param success
   * @param param
   * @param workResult
   */
  void result(boolean success, T param, WorkResult<V> workResult);
}
