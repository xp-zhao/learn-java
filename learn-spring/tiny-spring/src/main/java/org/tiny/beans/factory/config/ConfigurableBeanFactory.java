package org.tiny.beans.factory.config;

import org.tiny.beans.factory.HierarchicalBeanFactory;

/** @author zhaoxiaoping @Description: 可配置的 bean 工厂 @Date 2021-8-24 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
  String SCOPE_SINGLETON = "singleton";

  String SCOPE_PROTOTYPE = "prototype";

  /**
   * 添加 bean 对象修改接口
   *
   * @param beanPostProcessor bean 对象修改接口
   */
  void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
