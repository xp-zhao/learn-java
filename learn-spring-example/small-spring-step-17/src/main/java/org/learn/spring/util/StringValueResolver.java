package org.learn.spring.util;

/**
 * Simple strategy interface for resolving a String value.
 *
 * @author zhaoxiaoping
 * @date 2022-5-7
 */
public interface StringValueResolver {

  /**
   * 解决字符串值
   *
   * @param strVal 字符串值
   * @return {@code String}
   */
  String resolveStringValue(String strVal);
}
