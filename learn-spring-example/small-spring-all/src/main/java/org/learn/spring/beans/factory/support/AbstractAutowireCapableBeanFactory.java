package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;

/**
 * BeanFactory 抽象类, 负责实例化 Bean 对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
  @Override
  public Object createBean(String beanName, BeanDefinition beanDefinition) {
    Object bean = null;
    try {
      bean = beanDefinition.getBeanClass().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    // 注册单例对象
    addSingleton(beanName, bean);
    return bean;
  }
}
