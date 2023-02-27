package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValues;

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

  /**
   * 对象实例化之后, 设置属性值的操作之前执行此方法
   *
   * @param pvs
   * @param bean
   * @param beanName
   * @return
   */
  PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName);
}
