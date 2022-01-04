package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK 实例化策略
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

  @Override
  public Object instantiate(
      BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args)
      throws BeansException {
    Class clazz = beanDefinition.getBeanClass();
    try {
      if (null != ctor) {
        return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
      } else {
        return clazz.getDeclaredConstructor().newInstance();
      }
    } catch (NoSuchMethodException
        | InstantiationException
        | IllegalAccessException
        | InvocationTargetException e) {
      throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
    }
  }
}
