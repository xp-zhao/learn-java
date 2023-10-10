package async.demo;
/**
 * 工作线程
 *
 * @author zhaoxiaoping
 * @date 2023-6-15
 */
public interface Worker {
  /**
   * 耗时操作
   *
   * @param object
   * @return
   */
  String action(Object object);
}
