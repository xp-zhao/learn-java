package java.org.learn.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * 访问者接口
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public interface Advisor {
  /**
   * Return the advice part of this aspect. An advice may be an interceptor, a before advice, a
   * throws advice, etc.
   *
   * @return the advice that should apply if the pointcut matches
   * @see org.aopalliance.intercept.MethodInterceptor
   * @see BeforeAdvice
   */
  Advice getAdvice();
}
