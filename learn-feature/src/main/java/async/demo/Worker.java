package async.demo;
/**
 * 工作线程
 *
 * @author zhaoxiaoping
 * @date 2023-6-15
 */
public interface Worker {
  String action(Object object);
}
