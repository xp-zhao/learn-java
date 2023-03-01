package org.learn.spring.core.convert.support;

import org.learn.spring.core.convert.converter.Converter;
import org.learn.spring.core.convert.converter.ConverterFactory;
import org.learn.spring.util.NumberUtils;

/**
 * String 转 Number 类型转换工厂
 *
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {
  @Override
  public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
    return new StringToNumber<>(targetType);
  }

  private static final class StringToNumber<T extends Number> implements Converter<String, T> {

    private final Class<T> targetType;

    private StringToNumber(Class<T> targetType) {
      this.targetType = targetType;
    }

    @Override
    public T convert(String source) {
      if (source.isEmpty()) {
        return null;
      }
      return NumberUtils.parseNumber(source, this.targetType);
    }
  }
}
