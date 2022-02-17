package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanDefinition 修改接口，允许自定义修改 BeanDefinition 属性信息
 *
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public interface BeanFactoryPostProcessor {
  /**
   * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
   *
   * @param beanFactory bean工厂
   * @throws BeansException 异常
   */
  void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
