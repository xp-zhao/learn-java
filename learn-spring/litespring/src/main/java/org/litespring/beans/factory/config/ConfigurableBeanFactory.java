package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

/**
 * 提供设置 classloader 的能力
 *
 * @author xp-zhao
 * @date 2018/7/24
 */
public interface ConfigurableBeanFactory extends BeanFactory {

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
}
