package org.learn.spring.beans.factory.config;

/**
 * 单例注册接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public interface SingletonBeanRegistry {
  /**
   * 获取单例对象
   *
   * @param beanName
   * @return
   */
  Object getSingleton(String beanName);

  /**
   * 注册单例对象
   *
   * @param beanName
   * @param singletonObject
   */
  void registerSingleton(String beanName, Object singletonObject);
}
