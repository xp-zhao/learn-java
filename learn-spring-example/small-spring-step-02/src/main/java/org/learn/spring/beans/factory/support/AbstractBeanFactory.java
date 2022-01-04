package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.BeanFactory;
import org.learn.spring.beans.factory.config.BeanDefinition;

/**
 * 抽象 Bean 工厂实现
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
    implements BeanFactory {

  @Override
  public Object getBean(String beanName) throws BeansException {
    Object bean = getSingleton(beanName);
    if (bean != null) {
      return bean;
    }
    BeanDefinition beanDefinition = getBeanDefinition(beanName);
    return createBean(beanName, beanDefinition);
  }

  /**
   * 获取Bean定义
   *
   * @param beanName bean的名字
   * @return {@code BeanDefinition}
   * @throws BeansException 异常
   */
  protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 创建 Bean 对象
   *
   * @param beanName bean的名字
   * @param beanDefinition bean定义
   * @return {@code Object}
   * @throws BeansException 异常
   */
  protected abstract Object createBean(String beanName, BeanDefinition beanDefinition)
      throws BeansException;
}
