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

  /**
   * 判断容器中是否已经包含指定名称的 Bean
   *
   * @param beanName
   * @return
   */
  boolean containsBeanDefinition(String beanName);
}
