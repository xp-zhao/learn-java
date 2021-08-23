package org.smallspring.beans.factory;

/** @author zhaoxiaoping @Description: 初始化 bean 接口 @Date 2021-8-23 */
public interface InitializingBean {
  /**
   * Bean 处理了属性填充后调用
   *
   * @throws Exception
   */
  void afterPropertiesSet() throws Exception;
}
