package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;

/**
 * BeanFactory 感知接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-21
 */
public interface BeanFactoryAware extends Aware {
  /**
   * 设置 bean 对象的 BeanFactory
   *
   * @param beanFactory
   * @throws BeansException
   */
  void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
