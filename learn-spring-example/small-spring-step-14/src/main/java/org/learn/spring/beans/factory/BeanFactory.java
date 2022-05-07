package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;

/**
 * Bean 工厂接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public interface BeanFactory {
  /**
   * 通过 Bean 名称获取 Bean 对象
   *
   * @param beanName bean的名字
   * @return {@code Object}
   * @throws BeansException 异常
   */
  Object getBean(String beanName) throws BeansException;

  /**
   * 通过 Bean 名称和构造参数，获取 Bean 对象
   *
   * @param name 的名字
   * @param args 构造函数入参
   * @return {@code Object}
   * @throws BeansException 异常
   */
  Object getBean(String name, Object... args) throws BeansException;

  /**
   * 通过 Bean 名称和类型，获取 Bean 对象
   *
   * @param name 名字
   * @param requiredType 所需类型
   * @return {@link T}
   * @throws BeansException 豆子例外
   */
  <T> T getBean(String name, Class<T> requiredType) throws BeansException;

  /**
   * 通过 Bean 类型, 获取 Bean 对象
   *
   * @param requiredType 所需类型
   * @return {@code T}
   * @throws BeansException 异常
   */
  <T> T getBean(Class<T> requiredType) throws BeansException;
}
