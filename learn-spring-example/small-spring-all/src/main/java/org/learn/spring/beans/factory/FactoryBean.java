package org.learn.spring.beans.factory;

/**
 * FactoryBean 接口, 提供拓展对象的功能
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public interface FactoryBean<T> {
  /**
   * 获取对象
   *
   * @return
   * @throws Exception
   */
  T getObject() throws Exception;

  /**
   * 获取对象类型
   *
   * @return
   */
  Class<?> getObjectType();

  /**
   * 是否是单例
   *
   * @return
   */
  boolean isSingleton();
}
