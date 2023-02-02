package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.BeanFactory;
import org.learn.spring.beans.factory.config.BeanDefinition;

/**
 * 抽象 Bean 工厂, 统一获取 Bean 对象的逻辑
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
    implements BeanFactory {
  @Override
  public Object getBean(String beanName) throws BeansException {
    return doGetBean(beanName, null);
  }

  @Override
  public Object getBean(String beanName, Object... args) throws BeansException {
    return doGetBean(beanName, args);
  }

  @Override
  public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
    return (T) getBean(beanName);
  }

  protected <T> T doGetBean(final String beanName, final Object[] args) {
    Object singleton = getSingleton(beanName);
    if (singleton != null) {
      return (T) singleton;
    }
    BeanDefinition beanDefinition = getBeanDefinition(beanName);
    return (T) createBean(beanName, beanDefinition, args);
  }

  /**
   * 获取 Bean 定义
   *
   * @param beanName
   * @return
   * @throws BeansException
   */
  protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 创建 Bean 对象
   *
   * @param beanName
   * @param beanDefinition
   * @param args 构造函数入参
   * @return
   * @throws BeansException
   */
  protected abstract Object createBean(
      String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
