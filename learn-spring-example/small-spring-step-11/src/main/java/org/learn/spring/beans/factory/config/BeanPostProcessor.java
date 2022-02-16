package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;

/**
 * Bean 对象修改接口，用于修改新实例化 Bean 对象的扩展点
 *
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public interface BeanPostProcessor {
  /**
   * 在 Bean 对象执行初始化方法之前，执行此方法
   *
   * @param bean 实例对象
   * @param beanName bean的名字
   * @return {@code Object}
   * @throws BeansException 异常
   */
  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

  /**
   * 在 Bean 对象执行初始化方法之后，执行此方法
   *
   * @param bean 实例对象
   * @param beanName bean的名字
   * @return {@code Object}
   * @throws BeansException 异常
   */
  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
