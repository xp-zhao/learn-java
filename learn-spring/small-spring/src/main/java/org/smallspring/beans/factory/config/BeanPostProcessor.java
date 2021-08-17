package org.smallspring.beans.factory.config;

import org.smallspring.beans.BeansException;

/** @author zhaoxiaoping @Description: 实例化 Bean 对象的拓展点 @Date 2021-8-17 */
public interface BeanPostProcessor {
  /**
   * 在 Bean 对象执行初始化方法之前，执行此方法
   *
   * @param bean
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

  /**
   * 在 Bean 对象执行初始化方法之后，执行此方法
   *
   * @param bean
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
