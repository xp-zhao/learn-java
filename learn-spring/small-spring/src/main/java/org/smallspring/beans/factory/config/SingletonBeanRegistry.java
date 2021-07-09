package org.smallspring.beans.factory.config;

/**
 * @Author: xp-zhao @Description: TODO @DateTime: 2021/7/8 11:34 下午
 */
public interface SingletonBeanRegistry {

  /**
   * 通过 bean 名称获取单例对象
   *
   * @param beanName bean名称
   * @return 单例对象
   */
  Object getSingleton(String beanName);
}
