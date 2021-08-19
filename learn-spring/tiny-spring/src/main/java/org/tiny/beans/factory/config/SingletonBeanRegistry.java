package org.tiny.beans.factory.config;

/** @author zhaoxiaoping @Description: 单例 bean 注册接口 @Date 2021-8-19 */
public interface SingletonBeanRegistry {

  /**
   * 通过 bean 名称获取单例对象
   *
   * @param beanName bean名称
   * @return 单例对象
   */
  Object getSingleton(String beanName);
}
