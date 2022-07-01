package java.org.learn.spring.aop.framework;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.learn.spring.aop.AdvisedSupport;

/**
 * cglib 代理
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class Cglib2AopProxy implements AopProxy {

  private final AdvisedSupport advised;

  public Cglib2AopProxy(AdvisedSupport advised) {
    this.advised = advised;
  }

  @Override
  public Object getProxy() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(advised.getTargetSource().getTarget().getClass());
    enhancer.setInterfaces(advised.getTargetSource().getTargetClass());
    enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
    return enhancer.create();
  }

  private static class DynamicAdvisedInterceptor implements MethodInterceptor {

    private final AdvisedSupport advised;

    private DynamicAdvisedInterceptor(AdvisedSupport advised) {
      this.advised = advised;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable {
      CglibMethodInvocation methodInvocation =
          new CglibMethodInvocation(
              advised.getTargetSource().getTarget(), method, objects, methodProxy);
      if (advised
          .getMethodMatcher()
          .matches(method, advised.getTargetSource().getTarget().getClass())) {
        return advised.getMethodInterceptor().invoke(methodInvocation);
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
