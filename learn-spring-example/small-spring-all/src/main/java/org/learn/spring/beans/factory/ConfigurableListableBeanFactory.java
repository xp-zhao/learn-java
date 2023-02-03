package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.AutowireCapableBeanFactory;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * BeanFactory 拓展接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface ConfigurableListableBeanFactory
    extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

  /**
   * 获取 BeanDefinition
   *
   * @param beanName
   * @return
   * @throws BeansException
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 提前实例化单例对象
   *
   * @throws BeansException
   */
  void preInstantiateSingletons() throws BeansException;
}
