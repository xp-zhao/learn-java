package org.smallspring.beans.factory.supprot;

import org.smallspring.beans.factory.config.BeanDefinition;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-9
 **/
public interface BeanDefinitionRegistry {

  /**
   * 注册 beanDefinition
   *
   * @param beanName
   * @param beanDefinition
   */
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
