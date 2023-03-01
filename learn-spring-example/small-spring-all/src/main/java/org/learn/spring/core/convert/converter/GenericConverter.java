package org.learn.spring.core.convert.converter;

import cn.hutool.core.lang.Assert;

import java.util.Objects;
import java.util.Set;

/**
 * 通用转换接口
 *
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
public interface GenericConverter {

  /** Return the source and target types that this converter can convert between. */
  Set<ConvertiblePair> getConvertibleTypes();

  /**
   * Convert the source object to the targetType described by the {@code TypeDescriptor}.
   *
   * @param source the source object to convert (may be {@code null})
   * @param sourceType the type descriptor of the field we are converting from
   * @param targetType the type descriptor of the field we are converting to
   * @return the converted object
   */
  Object convert(Object source, Class sourceType, Class targetType);

  final class ConvertiblePair {
    private final Class<?> sourceType;
    private final Class<?> targetType;

    public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
      Assert.notNull(sourceType, "Source type must not be null");
      Assert.notNull(targetType, "Target type must not be null");
      this.sourceType = sourceType;
      this.targetType = targetType;
    }

    public Class<?> getSourceType() {
      return sourceType;
    }

    public Class<?> getTargetType() {
      return targetType;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ConvertiblePair that = (ConvertiblePair) o;
      return Objects.equals(sourceType, that.sourceType)
          && Objects.equals(targetType, that.targetType);
    }

    @Override
    public int hashCode() {
      return Objects.hash(sourceType, targetType);
    }
  }
}
