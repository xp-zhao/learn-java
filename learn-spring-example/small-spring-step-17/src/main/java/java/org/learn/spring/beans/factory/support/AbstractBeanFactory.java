package java.org.learn.spring.beans.factory.support;

import java.util.ArrayList;
import java.util.List;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.FactoryBean;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanPostProcessor;
import org.learn.spring.beans.factory.config.ConfigurableBeanFactory;
import org.learn.spring.util.ClassUtils;
import org.learn.spring.util.StringValueResolver;

/**
 * 抽象 Bean 工厂实现
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport
    implements ConfigurableBeanFactory {

  /** ClassLoader to resolve bean class names with, if necessary */
  private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

  /** BeanPostProcessors to apply in createBean */
  private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

  /** String resolvers to apply e.g. to annotation attribute values */
  private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<>();

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
    Object sharedInstance = getSingleton(name);
    if (sharedInstance != null) {
      return (T) getObjectForBeanInstance(sharedInstance, name);
    }
    BeanDefinition beanDefinition = getBeanDefinition(name);
    Object bean = createBean(name, beanDefinition, args);
    return (T) getObjectForBeanInstance(bean, name);
  }

  private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
    if (!(beanInstance instanceof FactoryBean)) {
      return beanInstance;
    }
    Object object = getCachedObjectForFactoryBean(beanName);
    if (object == null) {
      FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
      object = getObjectFromFactoryBean(factoryBean, beanName);
    }
    return object;
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

  @Override
  public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
    this.embeddedValueResolvers.add(valueResolver);
  }

  @Override
  public String resolveEmbeddedValue(String value) {
    String result = value;
    for (StringValueResolver resolver : this.embeddedValueResolvers) {
      result = resolver.resolveStringValue(result);
    }
    return result;
  }

  public List<BeanPostProcessor> getBeanPostProcessors() {
    return this.beanPostProcessors;
  }

  public ClassLoader getBeanClassLoader() {
    return beanClassLoader;
  }
}
