package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.FactoryBean;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanPostProcessor;
import org.learn.spring.beans.factory.config.ConfigurableBeanFactory;
import org.learn.spring.core.convert.ConversionService;
import org.learn.spring.util.ClassUtils;
import org.learn.spring.util.StringValueResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象 Bean 工厂, 统一获取 Bean 对象的逻辑
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport
    implements ConfigurableBeanFactory {

  private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
  private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

  /** 嵌入的值解析器 */
  private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

  private ConversionService conversionService;

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
      return (T) getObjectForBeanInstance(singleton, beanName);
    }
    BeanDefinition beanDefinition = getBeanDefinition(beanName);
    Object bean = createBean(beanName, beanDefinition, args);
    return (T) getObjectForBeanInstance(bean, beanName);
  }

  private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
    if (!(beanInstance instanceof FactoryBean)) {
      return beanInstance;
    }
    Object obj = getCachedObjectForFactoryBean(beanName);
    if (obj == null) {
      FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
      obj = getObjectFromFactoryBean(factoryBean, beanName);
    }
    return obj;
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

  @Override
  public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
    this.beanPostProcessors.remove(beanPostProcessor);
    this.beanPostProcessors.add(beanPostProcessor);
  }

  public List<BeanPostProcessor> getBeanPostProcessors() {
    return beanPostProcessors;
  }

  public ClassLoader getBeanClassLoader() {
    return beanClassLoader;
  }

  @Override
  public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
    this.embeddedValueResolvers.add(valueResolver);
  }

  @Override
  public String resolveEmbeddedValue(String value) {
    String result = value;
    for (StringValueResolver resolver : this.embeddedValueResolvers) {
      result = resolver.resolveStringValue(value);
    }
    return result;
  }

  @Override
  public void setConversionService(ConversionService conversionService) {
    this.conversionService = conversionService;
  }

  @Override
  public ConversionService getConversionService() {
    return conversionService;
  }
}
