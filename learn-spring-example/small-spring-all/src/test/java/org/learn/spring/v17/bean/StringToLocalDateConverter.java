package org.learn.spring.v17.bean;

import org.learn.spring.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

  private final DateTimeFormatter DATE_TIME_FORMATTER;

  public StringToLocalDateConverter(String pattern) {
    DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(pattern);
  }

  @Override
  public LocalDate convert(String source) {
    return LocalDate.parse(source, DATE_TIME_FORMATTER);
  }
}
