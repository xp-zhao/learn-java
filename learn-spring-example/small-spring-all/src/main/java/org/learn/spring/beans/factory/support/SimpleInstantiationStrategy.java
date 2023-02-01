package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * JDK 实例化策略
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
  @Override
  public Object instantiate(
      BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args)
      throws BeansException {
    Class beanClass = beanDefinition.getBeanClass();
    try {
      if (null != constructor) {
        return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
      } else {
        return beanClass.getDeclaredConstructor().newInstance();
      }
    } catch (Exception e) {
      throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
    }
  }
}
