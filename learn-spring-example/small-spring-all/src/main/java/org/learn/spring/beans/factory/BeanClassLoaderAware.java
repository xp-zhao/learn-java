package org.learn.spring.beans.factory;

/**
 * Bean 对象 ClassLoader 感知接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-21
 */
public interface BeanClassLoaderAware extends Aware {
  /**
   * 设置 bean 对象的类加载器
   *
   * @param classLoader
   */
  void setBeanClassLoader(ClassLoader classLoader);
}
