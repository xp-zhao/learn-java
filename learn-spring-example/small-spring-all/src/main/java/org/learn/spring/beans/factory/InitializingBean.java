package org.learn.spring.beans.factory;

/**
 * Bean 初始化接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-7
 */
public interface InitializingBean {
  /**
   * Bean 属性填充后调用
   *
   * @throws Exception
   */
  void afterPropertiesSet() throws Exception;
}
