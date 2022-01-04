package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.AutowireCapableBeanFactory;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public interface ConfigurableListableBeanFactory
    extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
  /**
   * 得到bean定义
   *
   * @param beanName bean名字
   * @return {@link BeanDefinition}
   * @throws BeansException 异常
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
