package org.learn.spring.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.learn.spring.aop.MethodBeforeAdvice;

/**
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

  private MethodBeforeAdvice advice;

  public MethodBeforeAdviceInterceptor() {}

  public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
    this.advice = advice;
  }

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    this.advice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
    return invocation.proceed();
  }
}
