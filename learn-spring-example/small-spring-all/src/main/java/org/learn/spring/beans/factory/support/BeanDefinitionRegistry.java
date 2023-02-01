package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition 注册接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public interface BeanDefinitionRegistry {
  /**
   * 注册 BeanDefinition
   *
   * @param beanName
   * @param beanDefinition
   */
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
