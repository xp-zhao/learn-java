package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.factory.HierarchicalBeanFactory;
import org.learn.spring.util.StringValueResolver;

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

  /**
   * 添加bean后置处理程序
   *
   * @param beanPostProcessor bean后置处理程序
   */
  void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

  /** 销毁单例对象 */
  void destroySingletons();

  /**
   * Add a String resolver for embedded values such as annotation attributes.
   *
   * @param valueResolver the String resolver to apply to embedded values
   * @since 3.0
   */
  void addEmbeddedValueResolver(StringValueResolver valueResolver);

  /**
   * Resolve the given embedded value, e.g. an annotation attribute.
   *
   * @param value the value to resolve
   * @return the resolved value (may be the original value as-is)
   * @since 3.0
   */
  String resolveEmbeddedValue(String value);
}
