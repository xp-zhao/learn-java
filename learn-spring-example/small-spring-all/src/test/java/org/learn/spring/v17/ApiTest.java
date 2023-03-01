package org.learn.spring.v17;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.core.convert.converter.Converter;
import org.learn.spring.core.convert.support.StringToNumberConverterFactory;
import org.learn.spring.v17.bean.Husband;
import org.learn.spring.v17.bean.StringToIntegerConverter;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_convert() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v17.xml");
    Husband husband = applicationContext.getBean("husband", Husband.class);
    log.info("测试结果：{}", husband);
  }

  @Test
  public void test_StringToIntegerConverter() {
    StringToIntegerConverter converter = new StringToIntegerConverter();
    Integer num = converter.convert("1234");
    log.info("测试结果：{}", num);
  }

  @Test
  public void test_StringToNumberConverterFactory() {
    StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();

    Converter<String, Integer> stringToIntegerConverter =
        converterFactory.getConverter(Integer.class);
    log.info("测试结果：{}", stringToIntegerConverter.convert("1234"));

    Converter<String, Long> stringToLongConverter = converterFactory.getConverter(Long.class);
    log.info("测试结果：{}", stringToLongConverter.convert("1234"));
  }
}
