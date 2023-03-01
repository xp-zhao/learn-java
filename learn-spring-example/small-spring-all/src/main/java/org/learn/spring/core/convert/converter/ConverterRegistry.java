package org.learn.spring.core.convert.converter;

/**
 * 类型转换器注册接口
 *
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
public interface ConverterRegistry {
  /**
   * Add a plain converter to this registry. The convertible source/target type pair is derived from
   * the Converter's parameterized types.
   *
   * @throws IllegalArgumentException if the parameterized types could not be resolved
   */
  void addConverter(Converter<?, ?> converter);

  /** Add a generic converter to this registry. */
  void addConverter(GenericConverter converter);

  /**
   * Add a ranged converter factory to this registry. The convertible source/target type pair is
   * derived from the ConverterFactory's parameterized types.
   *
   * @throws IllegalArgumentException if the parameterized types could not be resolved
   */
  void addConverterFactory(ConverterFactory<?, ?> converterFactory);
}
