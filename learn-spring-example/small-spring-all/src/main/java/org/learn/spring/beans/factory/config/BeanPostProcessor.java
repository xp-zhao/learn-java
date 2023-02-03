package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;

/**
 * Bean 对象后置处理接口, 用于修改实例化后的对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface BeanPostProcessor {
  /**
   * 在 bean 对象执行初始化方法之前, 执行此方法
   *
   * @param bean
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

  /**
   * 在 bean 对象执行初始化方法之后, 执行此方法
   *
   * @param bean
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
