package org.litespring.beans.factory.config;

/**
 * @author xp-zhao
 * @date 2018/7/24
 */
public interface SingletonBeanRegistry {

  /**
   * 注册单例
   *
   * @param beanName beanName
   * @param singletonObject 单例对象
   */
  void registerSingleton(String beanName, Object singletonObject);

  /**
   * 获取单例对象
   *
   * @param beanName beanName
   * @return 单例对象
   */
  Object getSingleton(String beanName);
}
