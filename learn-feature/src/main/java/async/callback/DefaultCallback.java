package async.callback;

import async.worker.WorkResult;

/**
 * 默认回调类，如果 worker 没有设置回调类，会默认添加这个回调
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
public class DefaultCallback<T, V> implements ICallback<T, V> {

  @Override
  public void begin() {}

  @Override
  public void result(boolean success, T param, WorkResult<V> workResult) {}
}
