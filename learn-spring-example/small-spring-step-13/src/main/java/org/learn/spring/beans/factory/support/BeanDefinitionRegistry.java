package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
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

  /**
   * 通过bean名称获取bean定义
   *
   * @param beanName bean名字
   * @return {@link BeanDefinition}
   * @throws BeansException 异常
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 判断是否包含指定名称的BeanDefinition
   *
   * @param beanName bean名字
   * @return boolean
   */
  boolean containsBeanDefinition(String beanName);

  /**
   * 返回注册表中所有的Bean名称
   *
   * @return {@link String[]}
   */
  String[] getBeanDefinitionNames();
}
