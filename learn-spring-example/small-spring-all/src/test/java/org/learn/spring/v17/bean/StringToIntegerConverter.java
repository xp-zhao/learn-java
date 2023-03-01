package org.learn.spring.v17.bean;

import org.learn.spring.core.convert.converter.Converter;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

  @Override
  public Integer convert(String source) {
    return Integer.valueOf(source);
  }
}
