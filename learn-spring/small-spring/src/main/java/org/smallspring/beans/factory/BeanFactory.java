package org.smallspring.beans.factory;

import org.smallspring.beans.BeansException;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/8 11:33 下午 */
public interface BeanFactory {

  /**
   * 通过 bean 名称获取 bean 对象
   *
   * @param name bean名称
   * @return bean 对象
   * @throws BeansException 无法获取 bean 时抛出异常
   */
  Object getBean(String name) throws BeansException;

  /**
   * 通过 bean 名称和构造参数获取 bean 对象
   *
   * @param name bean 名称
   * @param args 构造参数
   * @return bean 对
   * @throws BeansException 无法获取 bean 时抛出异常
   */
  Object getBean(String name, Object... args) throws BeansException;

  <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
