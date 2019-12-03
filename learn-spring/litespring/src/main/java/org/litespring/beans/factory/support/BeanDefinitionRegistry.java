package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * @author xp-zhao
 * @date 2018/7/9
 */
public interface BeanDefinitionRegistry {

  /**
   * 通过 beanId 获取 BeanDefinition
   *
   * @param beanId beanId
   * @return BeanDefinition
   */
  BeanDefinition getBeanDefinition(String beanId);

  /**
   * 注册 BeanDefinition
   *
   * @param beanId beanId
   * @param bd BeanDefinition
   */
  void registerBeanDefinition(String beanId, BeanDefinition bd);
}
