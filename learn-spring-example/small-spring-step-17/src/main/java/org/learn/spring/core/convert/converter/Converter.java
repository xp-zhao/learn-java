package org.learn.spring.core.convert.converter;

/**
 * 类型转换处理接口
 *
 * @author zhaoxiaoping
 * @date 2022-6-7
 */
public interface Converter<S, T> {
  /** Convert the source object of type {@code S} to target type {@code T}. */
  T convert(S source);
}
