package org.tiny.beans.factory.support;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.tiny.beans.BeansException;
import org.tiny.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: jdk 实例化 @Date 2021-8-20 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

  @Override
  public Object instantiate(
      BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args)
      throws BeansException {
    Class<?> beanClass = beanDefinition.getBeanClass();
    try {
      if (null != ctor) {
        // 指定了构造函数
        return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
      } else {
        return beanClass.getDeclaredConstructor().newInstance();
      }
    } catch (InstantiationException
        | InvocationTargetException
        | IllegalAccessException
        | NoSuchMethodException e) {
      throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
    }
  }
}
