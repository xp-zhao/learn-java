package org.learn.spring.util;

/**
 * String 类型值解析器
 *
 * @author zhaoxiaoping
 * @date 2023-2-27
 */
public interface StringValueResolver {
  /**
   * 解析 String 值
   *
   * @param strVal
   * @return
   */
  String resolveStringValue(String strVal);
}
