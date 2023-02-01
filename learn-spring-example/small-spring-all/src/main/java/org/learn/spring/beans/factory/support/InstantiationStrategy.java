package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 对象实例化策略接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public interface InstantiationStrategy {
  /**
   * 对象实例化
   *
   * @param beanDefinition
   * @param beanName
   * @param constructor
   * @param args
   * @return
   * @throws BeansException
   */
  Object instantiate(
      BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args)
      throws BeansException;
}
