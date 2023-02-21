package org.learn.spring.beans.factory;

/**
 * BeanName 感知接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-21
 */
public interface BeanNameAware extends Aware {
  /**
   * 设置 BeanName
   *
   * @param beanName
   */
  void setBeanName(String beanName);
}
