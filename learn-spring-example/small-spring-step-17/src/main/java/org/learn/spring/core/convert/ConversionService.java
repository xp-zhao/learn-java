package org.learn.spring.core.convert;

import com.sun.istack.internal.Nullable;

/**
 * 类型转换抽象接口
 *
 * @author zhaoxiaoping
 * @date 2022-6-7
 */
public interface ConversionService {
  /**
   * Return {@code true} if objects of {@code sourceType} can be converted to the {@code
   * targetType}.
   */
  boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);

  /** Convert the given {@code source} to the specified {@code targetType}. */
  <T> T convert(Object source, Class<T> targetType);
}
