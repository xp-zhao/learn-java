package org.smallspring.beans.factory.supprot;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.BeanDefinition;

/**
 * @author zhaoxiaoping
 * @Description: jdk 实例化
 * @Date 2021-7-10
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy {

  @Override
  public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,
      Object[] args) {
    Class beanClass = beanDefinition.getBeanClass();
    try {
      if (null != constructor) {
        return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
      } else {
        return beanClass.getDeclaredConstructor().newInstance();
      }
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
    }
  }
}
