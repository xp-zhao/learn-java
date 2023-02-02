package org.learn.spring.core.convert.support;

import org.learn.spring.core.convert.converter.ConverterRegistry;

/**
 * 默认转换服务
 *
 * @author zhaoxiaoping
 * @date 2022-6-7
 */
public class DefaultConversionService extends GenericConversionService {

  public DefaultConversionService() {
    addDefaultConverters(this);
  }

  public static void addDefaultConverters(ConverterRegistry converterRegistry) {
    // 添加各类类型转换工厂
    converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
  }
}
