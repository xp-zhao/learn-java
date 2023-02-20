package org.learn.spring.beans.factory;

/**
 * Bean 对象销毁接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-7
 */
public interface DisposableBean {
  /**
   * Bean 对象销毁后调用此方法
   *
   * @throws Exception
   */
  void destroy() throws Exception;
}
