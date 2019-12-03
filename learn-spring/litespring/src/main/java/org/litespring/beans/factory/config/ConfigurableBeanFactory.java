package org.litespring.beans.factory.config;

import java.util.List;

/**
 * 提供设置 classloader 的能力
 *
 * @author xp-zhao
 * @date 2018/7/24
 */
public interface ConfigurableBeanFactory extends AutowireCapableBeanFactory {

  /**
   * 为 bean 设置 classloader
   *
   * @param beanClassLoader 类加载器
   */
  void setBeanClassLoader(ClassLoader beanClassLoader);

  /**
   * 获取类加载器
   *
   * @return 当前使用的类加载器
   */
  ClassLoader getBeanClassLoader();
  void addBeanPostProcessor(BeanPostProcessor postProcessor);
  List<BeanPostProcessor> getBeanPostProcessors();
}
