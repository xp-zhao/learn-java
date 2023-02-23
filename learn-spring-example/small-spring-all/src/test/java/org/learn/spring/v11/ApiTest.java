package org.learn.spring.v11;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import org.learn.spring.aop.AdvisedSupport;
import org.learn.spring.aop.MethodMatcher;
import org.learn.spring.aop.TargetSource;
import org.learn.spring.aop.aspectj.AspectJExpressionPointcut;
import org.learn.spring.aop.framework.CglibAopProxy;
import org.learn.spring.aop.framework.JdkDynamicAopProxy;
import org.learn.spring.aop.framework.ReflectiveMethodInvocation;
import org.learn.spring.v11.bean.IUserService;
import org.learn.spring.v11.bean.UserService;
import org.learn.spring.v11.bean.UserServiceInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
@Slf4j
public class ApiTest {

  @Test
  public void test_dynamic() {
    // 目标对象
    IUserService userService = new UserService();
    // 组装代理信息
    AdvisedSupport advisedSupport = new AdvisedSupport();
    advisedSupport.setTargetSource(new TargetSource(userService));
    advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
    advisedSupport.setMethodMatcher(
        new AspectJExpressionPointcut("execution(* org.learn.spring.v11.bean.IUserService.*(..))"));
    // jdk 动态代理
    IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
    log.info("proxy_jdk 测试结果: {}", proxy_jdk.queryUserInfo());
    // cglib 动态代理
    IUserService proxy_cglib = (IUserService) new CglibAopProxy(advisedSupport).getProxy();
    log.info("proxy_cglib 测试结果: {}", proxy_cglib.register("xp"));
  }

  @Test
  public void test_proxy_class() {
    IUserService userService =
        (IUserService)
            Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[] {IUserService.class},
                (proxy, method, args) -> String.format("代理方法: %s", method.getName()));
    String result = userService.queryUserInfo();
    log.info("测试结果: {}", result);
    result = userService.register("xxx");
    log.info("测试结果: {}", result);
  }

  @Test
  public void test_aop() throws NoSuchMethodException {
    AspectJExpressionPointcut pointcut =
        new AspectJExpressionPointcut("execution(* org.learn.spring.v11.bean.UserService.*(..))");
    Class<UserService> clazz = UserService.class;
    Method method = clazz.getDeclaredMethod("queryUserInfo");

    log.info("类匹配结果: {}", pointcut.matches(clazz));
    log.info("方法匹配结果: {}", pointcut.matches(method, clazz));
  }

  @Test
  public void test_proxy_method() {
    // 目标对象
    Object targetObj = new UserService();
    // aop 代理
    IUserService proxy =
        (IUserService)
            Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                targetObj.getClass().getInterfaces(),
                new InvocationHandler() {
                  // 方法匹配器
                  MethodMatcher methodMatcher =
                      new AspectJExpressionPointcut(
                          "execution(* org.learn.spring.v11.bean.IUserService.*(..))");

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
                              log.info("监控 - Begin By AOP");
                              log.info("方法名称：{}", invocation.getMethod().getName());
                              log.info("方法耗时：{} ms", (System.currentTimeMillis() - start));
                              log.info("监控 - End");
                            }
                          };
                      // 反射调用
                      return methodInterceptor.invoke(
                          new ReflectiveMethodInvocation(targetObj, method, args));
                    }
                    return method.invoke(targetObj, args);
                  }
                });
    log.info("测试结果：" + proxy.queryUserInfo());
    log.info("测试结果：" + proxy.register("xp"));
  }
}
