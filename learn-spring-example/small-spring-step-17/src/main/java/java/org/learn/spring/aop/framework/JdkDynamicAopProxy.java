package java.org.learn.spring.aop.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.learn.spring.aop.AdvisedSupport;

/**
 * jdk 动态代理
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

  private final AdvisedSupport advised;

  public JdkDynamicAopProxy(AdvisedSupport advised) {
    this.advised = advised;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (advised
        .getMethodMatcher()
        .matches(method, advised.getTargetSource().getTarget().getClass())) {
      MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
      return methodInterceptor.invoke(
          new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
    }
    return method.invoke(advised.getTargetSource().getTarget(), args);
  }

  @Override
  public Object getProxy() {
    return Proxy.newProxyInstance(
        Thread.currentThread().getContextClassLoader(),
        advised.getTargetSource().getTargetClass(),
        this);
  }
}
