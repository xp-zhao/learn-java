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
    Object singleton = getSingleton(beanName);
    if (singleton != null) {
      return singleton;
    }
    BeanDefinition beanDefinition = getBeanDefinition(beanName);
    return createBean(beanName, beanDefinition);
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
   * @return
   * @throws BeansException
   */
  protected abstract Object createBean(String beanName, BeanDefinition beanDefinition)
      throws BeansException;
}
