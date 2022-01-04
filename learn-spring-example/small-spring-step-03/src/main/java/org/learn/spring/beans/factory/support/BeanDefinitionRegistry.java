package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.factory.config.BeanDefinition;

/**
 * Bean定义注册接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public interface BeanDefinitionRegistry {
  /**
   * 向注册表中注册 BeanDefinition
   *
   * @param beanName bean名称
   * @param beanDefinition bean 定义
   */
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
