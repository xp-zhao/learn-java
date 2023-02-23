package org.learn.spring.aop;

/**
 * 类过滤接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public interface ClassFilter {
  /**
   * 判断目标类是否匹配
   *
   * @param clazz
   * @return
   */
  boolean matches(Class<?> clazz);
}
