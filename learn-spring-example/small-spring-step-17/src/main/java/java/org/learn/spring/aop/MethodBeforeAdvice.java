package java.org.learn.spring.aop;

import java.lang.reflect.Method;

/**
 * 方法拦截器接口
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
  /**
   * Callback before a given method is invoked.
   *
   * @param method method being invoked
   * @param args arguments to the method
   * @param target target of the method invocation. May be <code>null</code>.
   * @throws Throwable if this object wishes to abort the call. Any exception thrown will be
   *     returned to the caller if it's allowed by the method signature. Otherwise the exception
   *     will be wrapped as a runtime exception.
   */
  void before(Method method, Object[] args, Object target) throws Throwable;
}
