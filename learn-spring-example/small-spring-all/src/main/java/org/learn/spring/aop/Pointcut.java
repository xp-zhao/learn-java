package org.learn.spring.aop;

/**
 * 切入点接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public interface Pointcut {
  /**
   * 获取切入点的类匹配器
   *
   * @return
   */
  ClassFilter getClassFilter();

  /**
   * 获取切入点的方法匹配器
   *
   * @return
   */
  MethodMatcher getMethodMatcher();
}
