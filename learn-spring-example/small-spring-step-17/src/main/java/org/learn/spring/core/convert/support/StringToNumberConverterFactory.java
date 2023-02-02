package org.learn.spring.core.convert.support;

import com.sun.istack.internal.Nullable;
import org.learn.spring.core.convert.converter.Converter;
import org.learn.spring.core.convert.converter.ConverterFactory;
import org.learn.spring.util.NumberUtils;

/**
 * @author zhaoxiaoping
 * @date 2022-6-7
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

  @Override
  public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
    return new StringToNumber<>(targetType);
  }

  private static final class StringToNumber<T extends Number> implements Converter<String, T> {

    private final Class<T> targetType;

    public StringToNumber(Class<T> targetType) {
      this.targetType = targetType;
    }

    @Override
    @Nullable
    public T convert(String source) {
      if (source.isEmpty()) {
        return null;
      }
      return NumberUtils.parseNumber(source, this.targetType);
    }
  }
}
