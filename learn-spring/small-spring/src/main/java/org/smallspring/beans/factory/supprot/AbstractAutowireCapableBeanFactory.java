package org.smallspring.beans.factory.supprot;

import cn.hutool.core.bean.BeanUtil;
import org.smallspring.beans.BeansException;
import org.smallspring.beans.PropertyValue;
import org.smallspring.beans.PropertyValues;
import org.smallspring.beans.factory.config.BeanDefinition;
import org.smallspring.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/** @author zhaoxiaoping @Description: @Date 2021-7-9 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

  private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args)
      throws BeansException {
    Object bean = null;
    try {
      bean = createBeanInstance(beanDefinition, beanName, args);
      // 填充属性
      applyPropertyValues(beanName, bean, beanDefinition);
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    // 注册单例对象
    addSingleton(beanName, bean);
    return bean;
  }

  protected Object createBeanInstance(
      BeanDefinition beanDefinition, String beanName, Object[] args) {
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

  protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
    try {
      PropertyValues propertyValues = beanDefinition.getPropertyValues();
      for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
        String name = propertyValue.getName();
        Object value = propertyValue.getValue();
        if (value instanceof BeanReference) {
          BeanReference beanReference = (BeanReference) value;
          value = getBean(beanReference.getBeanName());
        }
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
