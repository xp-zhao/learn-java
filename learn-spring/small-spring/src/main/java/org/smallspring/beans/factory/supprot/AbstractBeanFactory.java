package org.smallspring.beans.factory.supprot;

import java.util.ArrayList;
import java.util.List;
import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.BeanDefinition;
import org.smallspring.beans.factory.config.BeanPostProcessor;
import org.smallspring.beans.factory.config.ConfigurableBeanFactory;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/8 11:38 下午 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
    implements ConfigurableBeanFactory {

  private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

  @Override
  public Object getBean(String name) throws BeansException {
    return doGetBean(name, null);
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

  protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  protected abstract Object createBean(
      String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

  @Override
  public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
    this.beanPostProcessors.remove(beanPostProcessor);
    this.beanPostProcessors.add(beanPostProcessor);
  }

  /**
   * Return the list of BeanPostProcessors that will get applied to beans created with this factory.
   */
  public List<BeanPostProcessor> getBeanPostProcessors() {
    return this.beanPostProcessors;
  }
}
