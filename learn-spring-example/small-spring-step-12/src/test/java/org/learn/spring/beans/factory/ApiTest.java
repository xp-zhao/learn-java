package org.learn.spring.beans.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;
import org.learn.spring.aop.AdvisedSupport;
import org.learn.spring.aop.ClassFilter;
import org.learn.spring.aop.MethodMatcher;
import org.learn.spring.aop.TargetSource;
import org.learn.spring.aop.aspectj.AspectJExpressionPointcut;
import org.learn.spring.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.learn.spring.aop.framework.ProxyFactory;
import org.learn.spring.aop.framework.ReflectiveMethodInvocation;
import org.learn.spring.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.learn.spring.beans.IUserService;
import org.learn.spring.beans.UserService;
import org.learn.spring.beans.UserServiceBeforeAdvice;
import org.learn.spring.beans.UserServiceInterceptor;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;

public class ApiTest {

  private AdvisedSupport advisedSupport;

  @Before
  public void init() {
    // 目标对象
    IUserService userService = new UserService();
    // 组装代理信息
    advisedSupport = new AdvisedSupport();
    advisedSupport.setTargetSource(new TargetSource(userService));
    advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
    advisedSupport.setMethodMatcher(
        new AspectJExpressionPointcut("execution(* org.learn.spring.beans.IUserService.*(..))"));
  }

  @Test
  public void test_proxyFactory() {
    advisedSupport.setProxyTargetClass(true); // false/true，JDK动态代理、CGlib动态代理
    IUserService proxy = (IUserService) new ProxyFactory(advisedSupport).getProxy();

    System.out.println("测试结果：" + proxy.queryUserInfo());
  }

  @Test
  public void test_beforeAdvice() {
    UserServiceBeforeAdvice beforeAdvice = new UserServiceBeforeAdvice();
    MethodBeforeAdviceInterceptor interceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
    advisedSupport.setMethodInterceptor(interceptor);

    IUserService proxy = (IUserService) new ProxyFactory(advisedSupport).getProxy();
    System.out.println("测试结果：" + proxy.queryUserInfo());
  }

  @Test
  public void test_advisor() {
    // 目标对象
    IUserService userService = new UserService();

    AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
    advisor.setExpression("execution(* org.learn.spring.beans.IUserService.*(..))");
    advisor.setAdvice(new MethodBeforeAdviceInterceptor(new UserServiceBeforeAdvice()));

    ClassFilter classFilter = advisor.getPointcut().getClassFilter();
    if (classFilter.matches(userService.getClass())) {
      AdvisedSupport advisedSupport = new AdvisedSupport();

      TargetSource targetSource = new TargetSource(userService);
      advisedSupport.setTargetSource(targetSource);
      advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
      advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
      advisedSupport.setProxyTargetClass(true); // false/true，JDK动态代理、CGlib动态代理

      IUserService proxy = (IUserService) new ProxyFactory(advisedSupport).getProxy();
      System.out.println("测试结果：" + proxy.queryUserInfo());
    }
  }

  @Test
  public void test_aop() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");

    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    System.out.println("测试结果：" + userService.queryUserInfo());
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
