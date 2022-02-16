package org.learn.spring.beans.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import org.learn.spring.aop.AdvisedSupport;
import org.learn.spring.aop.MethodMatcher;
import org.learn.spring.aop.TargetSource;
import org.learn.spring.aop.aspectj.AspectJExpressionPointcut;
import org.learn.spring.aop.framework.Cglib2AopProxy;
import org.learn.spring.aop.framework.JdkDynamicAopProxy;
import org.learn.spring.aop.framework.ReflectiveMethodInvocation;
import org.learn.spring.beans.IUserService;
import org.learn.spring.beans.UserService;
import org.learn.spring.beans.UserServiceInterceptor;

public class ApiTest {

  @Test
  public void test_aop() throws NoSuchMethodException {
    AspectJExpressionPointcut pointcut =
        new AspectJExpressionPointcut("execution(* org.learn.spring.beans.UserService.*(..))");

    Class<UserService> clazz = UserService.class;
    Method method = clazz.getDeclaredMethod("queryUserInfo");

    System.out.println(pointcut.matches(clazz));
    System.out.println(pointcut.matches(method, clazz));
  }

  @Test
  public void test_dynamic() {
    // 目标对象
    IUserService userService = new UserService();
    // 组装代理信息
    AdvisedSupport advisedSupport = new AdvisedSupport();
    advisedSupport.setTargetSource(new TargetSource(userService));
    advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
    advisedSupport.setMethodMatcher(
        new AspectJExpressionPointcut("execution(* org.learn.spring.beans.IUserService.*(..))"));

    // 代理对象(JdkDynamicAopProxy)
    IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
    // 测试调用
    System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

    // 代理对象(Cglib2AopProxy)
    IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
    // 测试调用
    System.out.println("测试结果：" + proxy_cglib.register("花花"));
  }

  @Test
  public void test_proxy_class() {
    IUserService userService =
        (IUserService)
            Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[] {IUserService.class},
                (proxy, method, args) -> "你被代理了！");
    String result = userService.queryUserInfo();
    System.out.println("测试结果：" + result);
  }

  @Test
  public void test_proxy_method() {
    // 目标对象(可以替换成任何的目标对象)
    Object targetObj = new UserService();

    // AOP 代理
    IUserService proxy =
        (IUserService)
            Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                targetObj.getClass().getInterfaces(),
                new InvocationHandler() {
                  // 方法匹配器
                  MethodMatcher methodMatcher =
                      new AspectJExpressionPointcut(
                          "execution(* org.learn.spring.beans.IUserService.*(..))");

                  @Override
                  public Object invoke(Object proxy, Method method, Object[] args)
                      throws Throwable {
                    if (methodMatcher.matches(method, targetObj.getClass())) {
                      // 方法拦截器
                      MethodInterceptor methodInterceptor =
                          invocation -> {
                            long start = System.currentTimeMillis();
                            try {
                              return invocation.proceed();
                            } finally {
                              System.out.println("监控 - Begin By AOP");
                              System.out.println("方法名称：" + invocation.getMethod().getName());
                              System.out.println(
                                  "方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                              System.out.println("监控 - End\r\n");
                            }
                          };
                      // 反射调用
                      return methodInterceptor.invoke(
                          new ReflectiveMethodInvocation(targetObj, method, args));
                    }
                    return method.invoke(targetObj, args);
                  }
                });

    String result = proxy.queryUserInfo();
    System.out.println("测试结果：" + result);
  }
}
