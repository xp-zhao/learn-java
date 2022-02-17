package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
  /**
   * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>. The returned bean
   * object may be a proxy to use instead of the target bean, effectively suppressing default
   * instantiation of the target bean.
   *
   * <p>在 Bean 对象执行初始化方法之前，执行此方法
   *
   * @param beanClass
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
