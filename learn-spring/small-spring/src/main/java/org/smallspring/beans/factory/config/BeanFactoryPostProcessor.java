package org.smallspring.beans.factory.config;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.ConfigurableListableBeanFactory;

/** @author zhaoxiaoping @Description: @Date 2021-8-17 */
public interface BeanFactoryPostProcessor {
  /**
   * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
   *
   * @param beanFactory
   * @throws BeansException
   */
  void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
