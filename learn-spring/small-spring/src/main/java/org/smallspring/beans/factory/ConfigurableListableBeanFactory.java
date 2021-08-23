package org.smallspring.beans.factory;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.AutowireCapableBeanFactory;
import org.smallspring.beans.factory.config.BeanDefinition;
import org.smallspring.beans.factory.config.ConfigurableBeanFactory;

/** @author zhaoxiaoping @Description: @Date 2021-8-17 */
public interface ConfigurableListableBeanFactory
    extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

  /**
   * 获取 bean 定义对象
   *
   * @param beanName bean 名称
   * @return bean 定义对象
   * @throws BeansException 获取失败时抛出
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 提前实例化单例对象
   *
   * @throws BeansException 异常
   */
  void preInstantiateSingletons() throws BeansException;
}
