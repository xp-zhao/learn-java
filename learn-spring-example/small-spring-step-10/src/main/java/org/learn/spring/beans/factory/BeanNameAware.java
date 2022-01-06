package org.learn.spring.beans.factory;

/**
 * BeanName 感知接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public interface BeanNameAware extends Aware {
  /**
   * 设置bean名称
   *
   * @param name bean名称
   */
  void setBeanName(String name);
}
