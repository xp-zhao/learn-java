package java.org.learn.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Base class for AOP proxy configuration managers.
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class AdvisedSupport {

  /** ProxyConfig */
  private boolean proxyTargetClass = false;
  /** 被代理的目标对象 */
  private TargetSource targetSource;
  /** 方法拦截器 */
  private MethodInterceptor methodInterceptor;
  /** 方法匹配器(检查目标方法是否符合通知条件) */
  private MethodMatcher methodMatcher;

  public boolean isProxyTargetClass() {
    return proxyTargetClass;
  }

  public void setProxyTargetClass(boolean proxyTargetClass) {
    this.proxyTargetClass = proxyTargetClass;
  }

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
