package org.learn.spring.beans.factory.config;

import com.sun.istack.internal.Nullable;
import org.learn.spring.beans.factory.HierarchicalBeanFactory;
import org.learn.spring.core.convert.ConversionService;
import org.learn.spring.util.StringValueResolver;

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

  /** 销毁单例对象 */
  void destroySingletons();

  /**
   * 添加 String 值解析器
   *
   * @param valueResolver
   */
  void addEmbeddedValueResolver(StringValueResolver valueResolver);

  /**
   * 解析
   *
   * @param value
   * @return
   */
  String resolveEmbeddedValue(String value);

  void setConversionService(ConversionService conversionService);

  @Nullable
  ConversionService getConversionService();
}
