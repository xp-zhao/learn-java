package async.callback;

import async.wrapper.WorkerWrapper;
import java.util.Map;

/**
 * 工作线程接口, 每个最小执行单位需要实现的接口 <br>
 * T, V 泛型表示入参和出参类型<br>
 * 不同的 worker 直接没有关联，可以分别有不同的入参和出参
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
@FunctionalInterface
public interface IWorker<T, V> {
  /**
   * 在这里做耗时操作，如rpc请求、IO等
   *
   * @param object object
   * @param allWrapper 持有所以 wrapper 的引用，key 是 id
   */
  V action(T object, Map<String, WorkerWrapper> allWrapper);

  /**
   * 超时、异常时，返回的默认值
   *
   * @return 默认值
   */
  default V defaultValue() {
    return null;
  }
}
