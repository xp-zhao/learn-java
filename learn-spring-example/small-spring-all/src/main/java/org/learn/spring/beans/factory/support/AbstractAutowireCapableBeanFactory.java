package org.learn.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * BeanFactory 抽象类, 负责实例化 Bean 对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

  /** 对象实例化策略, 默认 cglib 策略 */
  private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

  @Override
  public Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
    Object bean = null;
    try {
      bean = createBeanInstance(beanDefinition, beanName, args);
      // 给 bean 对象填充属性
      applyPropertyValue(beanName, bean, beanDefinition);
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    // 注册单例对象
    addSingleton(beanName, bean);
    return bean;
  }

  protected Object createBeanInstance(
      BeanDefinition beanDefinition, String beanName, Object[] args) {
    Constructor constructorToUse = null;
    Class beanClass = beanDefinition.getBeanClass();
    Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
    for (Constructor declaredConstructor : declaredConstructors) {
      if (null != args && declaredConstructor.getParameterTypes().length == args.length) {
        constructorToUse = declaredConstructor;
        break;
      }
    }
    return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
  }

  /**
   * 填充对象属性
   *
   * @param beanName
   * @param bean
   * @param beanDefinition
   */
  protected void applyPropertyValue(String beanName, Object bean, BeanDefinition beanDefinition) {
    try {
      PropertyValues propertyValues = beanDefinition.getPropertyValues();
      for (PropertyValue pv : propertyValues.getPropertyValues()) {
        String name = pv.getName();
        Object value = pv.getValue();
        if (value instanceof BeanReference) {
          // 对象属性是另一个对象的引用
          BeanReference beanReference = (BeanReference) value;
          value = getBean(beanReference.getBeanName());
        }
        // 属性填充
        BeanUtil.setFieldValue(bean, name, value);
      }
    } catch (Exception e) {
      throw new BeansException("Error setting property values：" + beanName);
    }
  }

  public InstantiationStrategy getInstantiationStrategy() {
    return instantiationStrategy;
  }

  public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
    this.instantiationStrategy = instantiationStrategy;
  }
}
