package org.learn.spring.beans.factory.config;

/**
 * 单例注册接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public interface SingletonBeanRegistry {
  /**
   * 获取单例对象
   *
   * @param beanName bean的名字
   * @return {@code Object}
   */
  Object getSingleton(String beanName);

  /**
   * 注册单例对象
   *
   * @param beanName bean的名字
   * @param singletonObject 单例对象
   */
  void registerSingleton(String beanName, Object singletonObject);
}
