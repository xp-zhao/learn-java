package org.learn.spring.aop;

import java.lang.reflect.Method;

/**
 * 方法拦截器接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
  /**
   * Callback before a given method is invoked.
   *
   * @param method method being invoked
   * @param args arguments to the method
   * @param target target of the method invocation. May be <code>null</code>.
   * @throws Throwable
   */
  void before(Method method, Object[] args, Object target) throws Throwable;
}
