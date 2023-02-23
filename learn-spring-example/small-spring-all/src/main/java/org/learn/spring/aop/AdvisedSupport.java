package org.learn.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * aop 代理配置管理器
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class AdvisedSupport {
  /** 被代理的目标对象 */
  private TargetSource targetSource;
  /** 方法拦截器 */
  private MethodInterceptor methodInterceptor;
  /** 方法匹配器 */
  private MethodMatcher methodMatcher;

  public TargetSource getTargetSource() {
    return targetSource;
  }

  public void setTargetSource(TargetSource targetSource) {
    this.targetSource = targetSource;
  }

  public MethodInterceptor getMethodInterceptor() {
    return methodInterceptor;
  }

  public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
    this.methodInterceptor = methodInterceptor;
  }

  public MethodMatcher getMethodMatcher() {
    return methodMatcher;
  }

  public void setMethodMatcher(MethodMatcher methodMatcher) {
    this.methodMatcher = methodMatcher;
  }
}
