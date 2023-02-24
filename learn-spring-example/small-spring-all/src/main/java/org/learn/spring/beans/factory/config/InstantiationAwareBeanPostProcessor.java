package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;

/**
 * bean 对象实例化感知后置处理器
 *
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
  /**
   * 在 bean 对象实例化之前执行此方法
   *
   * @param beanClass
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
