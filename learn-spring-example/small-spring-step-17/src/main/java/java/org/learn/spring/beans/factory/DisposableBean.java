package java.org.learn.spring.beans.factory;

/**
 * Bean 销毁接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public interface DisposableBean {
  /**
   * Bean 对象销毁后调用此方法
   *
   * @throws Exception 异常
   */
  void destroy() throws Exception;
}
