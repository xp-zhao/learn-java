package org.learn.spring.aop.framework;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.learn.spring.aop.AdvisedSupport;
import org.learn.spring.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * cglib 代理
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class CglibAopProxy implements AopProxy {

  private final AdvisedSupport advisedSupport;

  public CglibAopProxy(AdvisedSupport advisedSupport) {
    this.advisedSupport = advisedSupport;
  }

  @Override
  public Object getProxy() {
    Enhancer enhancer = new Enhancer();
    Class<?> aClass = advisedSupport.getTargetSource().getTarget().getClass();
    aClass = ClassUtils.isCglibProxyClass(aClass) ? aClass.getSuperclass() : aClass;
    enhancer.setSuperclass(aClass);
    enhancer.setInterfaces(advisedSupport.getTargetSource().getTargetClass());
    enhancer.setCallback(new DynamicAdvisedInterceptor(advisedSupport));
    return enhancer.create();
  }

  private static class DynamicAdvisedInterceptor implements MethodInterceptor {

    private final AdvisedSupport advisedSupport;

    private DynamicAdvisedInterceptor(AdvisedSupport advisedSupport) {
      this.advisedSupport = advisedSupport;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable {
      CglibMethodInvocation methodInvocation =
          new CglibMethodInvocation(
              advisedSupport.getTargetSource().getTarget(), method, objects, methodProxy);
      if (advisedSupport
          .getMethodMatcher()
          .matches(method, advisedSupport.getTargetSource().getTarget().getClass())) {
        return advisedSupport.getMethodInterceptor().invoke(methodInvocation);
      }
      return methodInvocation.proceed();
    }

    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {

      private final MethodProxy methodProxy;

      public CglibMethodInvocation(
          Object target, Method method, Object[] arguments, MethodProxy methodProxy) {
        super(target, method, arguments);
        this.methodProxy = methodProxy;
      }

      @Override
      public Object proceed() throws Throwable {
        return this.methodProxy.invoke(this.target, this.arguments);
      }
    }
  }
}
