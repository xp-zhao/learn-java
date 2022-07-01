package java.org.learn.spring.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.learn.spring.aop.MethodBeforeAdvice;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

  private MethodBeforeAdvice advice;

  public MethodBeforeAdviceInterceptor() {}

  public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
    this.advice = advice;
  }

  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    this.advice.before(
        methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
    return methodInvocation.proceed();
  }

  public MethodBeforeAdvice getAdvice() {
    return advice;
  }

  public void setAdvice(MethodBeforeAdvice advice) {
    this.advice = advice;
  }
}
