package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;

/**
 * 抽象的实例化 Bean 对象工厂类
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition)
      throws BeansException {
    Object bean = null;
    try {
      bean = beanDefinition.getBeanClass().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    // 添加单例对象
    addSingleton(beanName, bean);
    return bean;
  }
}
