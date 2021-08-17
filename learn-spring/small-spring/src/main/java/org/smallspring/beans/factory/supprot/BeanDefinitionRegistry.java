package org.smallspring.beans.factory.supprot;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: @Date 2021-7-9 */
public interface BeanDefinitionRegistry {

  /**
   * 注册 beanDefinition
   *
   * @param beanName
   * @param beanDefinition
   */
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

  /**
   * 使用Bean名称查询BeanDefinition
   *
   * @param beanName
   * @return
   * @throws BeansException
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 判断是否包含指定名称的BeanDefinition
   *
   * @param beanName
   * @return
   */
  boolean containsBeanDefinition(String beanName);

  /**
   * Return the names of all beans defined in this registry.
   *
   * <p>返回注册表中所有的Bean名称
   */
  String[] getBeanDefinitionNames();
}
