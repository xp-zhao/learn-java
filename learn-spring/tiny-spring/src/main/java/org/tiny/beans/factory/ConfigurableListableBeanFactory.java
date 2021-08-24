package org.tiny.beans.factory;

import org.tiny.beans.BeansException;
import org.tiny.beans.factory.config.AutowireCapableBeanFactory;
import org.tiny.beans.factory.config.BeanDefinition;
import org.tiny.beans.factory.config.ConfigurableBeanFactory;

/** @author zhaoxiaoping @Description: 可配置的批量信息处理 Bean 工厂 @Date 2021-8-24 */
public interface ConfigurableListableBeanFactory
    extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

  /**
   * 通过 bean 名称获取 BeanDefinition
   *
   * @param beanName bean 名称
   * @return BeanDefinition
   * @throws BeansException 异常
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 提前实例化单例对象
   *
   * @throws BeansException 异常
   */
  void preInstantiateSingletons() throws BeansException;
}
