package org.tiny.beans.factory.supprot;

import org.tiny.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: bean 定义对象注册接口 @Date 2021-8-19 */
public interface BeanDefinitionRegistry {

  /**
   * 注册 BeanDefinition
   *
   * @param beanName 名称
   * @param beanDefinition 对象
   */
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
