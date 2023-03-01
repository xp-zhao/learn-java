package org.learn.spring.core.convert.support;

import org.learn.spring.core.convert.converter.ConverterRegistry;

/**
 * 默认类型转换服务
 *
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
public class DefaultConversionService extends GenericConversionService {
  public DefaultConversionService() {
    addDefaultConverters(this);
  }

  public static void addDefaultConverters(ConverterRegistry converterRegistry) {
    converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
  }
}
