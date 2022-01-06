package org.learn.spring.beans.factory.support;

import java.util.ArrayList;
import java.util.List;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanPostProcessor;
import org.learn.spring.beans.factory.config.ConfigurableBeanFactory;
import org.learn.spring.util.ClassUtils;

/**
 * 抽象 Bean 工厂实现
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
    implements ConfigurableBeanFactory {

  private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

  private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

  @Override
  public Object getBean(String beanName) throws BeansException {
    return doGetBean(beanName, null);
  }

  @Override
  public Object getBean(String name, Object... args) throws BeansException {
    return doGetBean(name, args);
  }

  @Override
  public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    return (T) getBean(name);
  }

  protected <T> T doGetBean(final String name, final Object[] args) {
    Object bean = getSingleton(name);
    if (bean != null) {
      return (T) bean;
    }

    BeanDefinition beanDefinition = getBeanDefinition(name);
    return (T) createBean(name, beanDefinition, args);
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
   * @param args 构造函数入参
   * @return {@code Object}
   * @throws BeansException 异常
   */
  protected abstract Object createBean(
      String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

  @Override
  public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
    this.beanPostProcessors.remove(beanPostProcessor);
    this.beanPostProcessors.add(beanPostProcessor);
  }

  public List<BeanPostProcessor> getBeanPostProcessors() {
    return this.beanPostProcessors;
  }

  public ClassLoader getBeanClassLoader() {
    return beanClassLoader;
  }
}
