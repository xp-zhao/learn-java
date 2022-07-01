package java.org.learn.spring.core.convert.converter;

/**
 * 类型转换工厂
 *
 * @author zhaoxiaoping
 * @date 2022-6-7
 */
public interface ConverterFactory<S, R> {
  /**
   * Get the converter to convert from S to target type T, where T is also an instance of R.
   *
   * @param <T> the target type
   * @param targetType the target type to convert to
   * @return a converter from S to T
   */
  <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
