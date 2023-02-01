package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;

/**
 * Bean 工厂接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public interface BeanFactory {
  /**
   * 获取 Bean 对象
   *
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object getBean(String beanName) throws BeansException;

  /**
   * 获取 Bean 对象
   *
   * @param beanName
   * @param args 构造函数入参
   * @return
   * @throws BeansException
   */
  Object getBean(String beanName, Object... args) throws BeansException;
}
