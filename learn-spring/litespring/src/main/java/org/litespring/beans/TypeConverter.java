package org.litespring.beans;

import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * @author xp-zhao
 * @date 2018/10/3
 */
public interface TypeConverter {

  /**
   * 类型转换
   *
   * @param value 值
   * @param requiredType 类型
   * @param <T> 期望转换的类型
   * @return 转换后的值
   * @throws TypeMismatchException 异常
   */
  <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;
}
