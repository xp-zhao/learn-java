package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.factory.HierarchicalBeanFactory;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
  /** 单例 */
  String SCOPE_SINGLETON = "singleton";

  /** 原型 */
  String SCOPE_PROTOTYPE = "prototype";
}
