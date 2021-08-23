package org.smallspring.beans.factory.config;

import org.smallspring.beans.factory.HierarchicalBeanFactory;

/** @author zhaoxiaoping @Description: @Date 2021-8-17 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
  String SCOPE_SINGLETON = "singleton";

  String SCOPE_PROTOTYPE = "prototype";

  /**
   * 添加后置处理
   *
   * @param beanPostProcessor
   */
  void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

  /** 销毁单例对象 */
  void destroySingletons();
}
