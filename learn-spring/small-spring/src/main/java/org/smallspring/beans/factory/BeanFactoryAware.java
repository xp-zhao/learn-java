package org.smallspring.beans.factory;

import org.smallspring.beans.BeansException;

/**
 * 实现此接口，既能感知到所属的 BeanFactory
 *
 * @author xp-zhao
 * @date 2022/1/5
 */
public interface BeanFactoryAware extends Aware {
  /**
   * 设置bean工厂
   *
   * @param beanFactory bean工厂
   * @throws BeansException 异常
   */
  void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
