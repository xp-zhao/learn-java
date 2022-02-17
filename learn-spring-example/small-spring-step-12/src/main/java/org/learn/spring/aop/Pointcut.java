package org.learn.spring.aop;

/**
 * 切入点接口
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public interface Pointcut {

  /**
   * Return the ClassFilter for this pointcut.
   *
   * @return the ClassFilter (never <code>null</code>)
   */
  ClassFilter getClassFilter();

  /**
   * Return the MethodMatcher for this pointcut.
   *
   * @return the MethodMatcher (never <code>null</code>)
   */
  MethodMatcher getMethodMatcher();
}
