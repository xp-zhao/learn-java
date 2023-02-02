package org.learn.spring.context.support;

import com.sun.istack.internal.Nullable;
import org.learn.spring.beans.factory.FactoryBean;
import org.learn.spring.beans.factory.InitializingBean;
import org.learn.spring.core.convert.ConversionService;
import org.learn.spring.core.convert.converter.Converter;
import org.learn.spring.core.convert.converter.ConverterFactory;
import org.learn.spring.core.convert.converter.ConverterRegistry;
import org.learn.spring.core.convert.converter.GenericConverter;
import org.learn.spring.core.convert.support.DefaultConversionService;
import org.learn.spring.core.convert.support.GenericConversionService;

import java.util.Set;

/**
 * 提供创建 ConversionService 工厂
 *
 * @author zhaoxiaoping
 * @date 2022-6-7
 */
public class ConversionServiceFactoryBean
    implements FactoryBean<ConversionService>, InitializingBean {

  @Nullable private Set<?> converters;

  @Nullable private GenericConversionService conversionService;

  @Override
  public ConversionService getObject() throws Exception {
    return conversionService;
  }

  @Override
  public Class<?> getObjectType() {
    return conversionService.getClass();
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    this.conversionService = new DefaultConversionService();
    registerConverters(converters, conversionService);
  }

  private void registerConverters(Set<?> converters, ConverterRegistry registry) {
    if (converters != null) {
      for (Object converter : converters) {
        if (converter instanceof GenericConverter) {
          registry.addConverter((GenericConverter) converter);
        } else if (converter instanceof Converter<?, ?>) {
          registry.addConverter((Converter<?, ?>) converter);
        } else if (converter instanceof ConverterFactory<?, ?>) {
          registry.addConverterFactory((ConverterFactory<?, ?>) converter);
        } else {
          throw new IllegalArgumentException(
              "Each converter object must implement one of the "
                  + "Converter, ConverterFactory, or GenericConverter interfaces");
        }
      }
    }
  }

  public void setConverters(Set<?> converters) {
    this.converters = converters;
  }
}
