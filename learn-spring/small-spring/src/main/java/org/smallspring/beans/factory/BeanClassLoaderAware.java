package org.smallspring.beans.factory;

/**
 * BeanClassLoader 感知接口
 *
 * @author xp-zhao
 * @date 2022/1/5
 */
public interface BeanClassLoaderAware extends Aware {
  /**
   * 设置bean类装入器
   *
   * @param classLoader 类装入器
   */
  void setBeanClassLoader(ClassLoader classLoader);
}
