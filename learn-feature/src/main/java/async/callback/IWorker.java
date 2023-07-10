package async.callback;

import async.wrapper.WorkerWrapper;
import java.util.Map;

/**
 * 工作线程接口, 每个最小执行单位需要实现的接口
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
public interface IWorker<T, V> {
  /**
   * 在这里做耗时操作，如rpc请求、IO等
   *
   * @param object object
   * @param allWrapper
   */
  V action(T object, Map<String, WorkerWrapper> allWrapper);

  /**
   * 超时、异常时，返回的默认值
   *
   * @return 默认值
   */
  V defaultValue();
}
