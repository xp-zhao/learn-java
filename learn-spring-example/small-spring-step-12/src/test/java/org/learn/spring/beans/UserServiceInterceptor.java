package org.learn.spring.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class UserServiceInterceptor implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    long start = System.currentTimeMillis();
    try {
      return invocation.proceed();
    } finally {
      System.out.println("监控 - Begin By AOP");
      System.out.println("方法名称：" + invocation.getMethod());
      System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
      System.out.println("监控 - End\r\n");
    }
  }
}
