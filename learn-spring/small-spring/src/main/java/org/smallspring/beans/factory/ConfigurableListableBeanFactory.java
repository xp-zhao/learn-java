package org.smallspring.beans.factory;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.AutowireCapableBeanFactory;
import org.smallspring.beans.factory.config.BeanDefinition;
import org.smallspring.beans.factory.config.ConfigurableBeanFactory;

/** @author zhaoxiaoping @Description: @Date 2021-8-17 */
public interface ConfigurableListableBeanFactory
    extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  void preInstantiateSingletons() throws BeansException;
}
