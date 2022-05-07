package org.learn.spring.beans.factory;

/**
 * FactoryBean 接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public interface FactoryBean<T> {
  /**
   * 获取对象
   *
   * @return {@code T}
   * @throws Exception 异常
   */
  T getObject() throws Exception;

  /**
   * 获取对象类型
   *
   * @return {@code Class<?>}
   */
  Class<?> getObjectType();

  /**
   * 是否是单例
   *
   * @return boolean
   */
  boolean isSingleton();
}
