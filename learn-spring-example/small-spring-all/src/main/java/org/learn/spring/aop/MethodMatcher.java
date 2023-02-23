package org.learn.spring.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配器
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public interface MethodMatcher {
  /**
   * 判断方法是否匹配
   *
   * @param method
   * @param targetClass
   * @return
   */
  boolean matches(Method method, Class<?> targetClass);
}
