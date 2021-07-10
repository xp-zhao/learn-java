package org.smallspring.beans.factory.supprot;

import java.lang.reflect.Constructor;
import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.BeanDefinition;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-9
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

  private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args)
      throws BeansException {
    Object bean = null;
    try {
      bean = createBeanInstance(beanDefinition, beanName, args);
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    // 注册单例对象
    addSingleton(beanName, bean);
    return bean;
  }

  protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName,
      Object[] args) {
    Constructor<?> constructorToUse = null;
    Class<?> beanClass = beanDefinition.getBeanClass();
    Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
    for (Constructor<?> constructor : declaredConstructors) {
      if (null != constructor && constructor.getParameterTypes().length == args.length) {
        constructorToUse = constructor;
        break;
      }
    }
    return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
  }

  public InstantiationStrategy getInstantiationStrategy() {
    return instantiationStrategy;
  }

  public void setInstantiationStrategy(
      InstantiationStrategy instantiationStrategy) {
    this.instantiationStrategy = instantiationStrategy;
  }
}
