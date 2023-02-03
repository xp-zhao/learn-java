package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.factory.HierarchicalBeanFactory;

/**
 * BeanFactory 拓展接口, 负责添加 bean 对象后置处理器
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
  /** 单例 */
  String SCOPE_SINGLETON = "singleton";

  /** 原型 */
  String SCOPE_PROTOTYPE = "prototype";

  /**
   * 添加 bean 对象后置处理器
   *
   * @param beanPostProcessor
   */
  void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
