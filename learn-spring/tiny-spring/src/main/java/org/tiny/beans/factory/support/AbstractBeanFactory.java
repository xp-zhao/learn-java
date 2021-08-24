package org.tiny.beans.factory.support;

import java.util.ArrayList;
import java.util.List;
import org.tiny.beans.BeansException;
import org.tiny.beans.factory.config.BeanDefinition;
import org.tiny.beans.factory.config.BeanPostProcessor;
import org.tiny.beans.factory.config.ConfigurableBeanFactory;

/** @author zhaoxiaoping @Description: 抽象 bean 工厂 @Date 2021-8-19 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
    implements ConfigurableBeanFactory {

  private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

  @Override
  public Object getBean(String beanName) throws BeansException {
    return doGetBean(beanName, null);
  }

  @Override
  public Object getBean(String beanName, Object... args) throws BeansException {
    return doGetBean(beanName, args);
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
   * 通过 bean 名称获取 BeanDefinition 对象
   *
   * @param beanName bean 名称
   * @return bean 定义对象
   * @throws BeansException 找不到时抛出
   */
  protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 创建 bean 对象
   *
   * @param beanName 名称
   * @param beanDefinition 定义对象
   * @param args 构造参数
   * @return bean 对象
   * @throws BeansException 创建失败时抛出
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
}
