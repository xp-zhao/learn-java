package org.learn.spring.v11.bean;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
@Slf4j
public class UserServiceInterceptor implements MethodInterceptor {
  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    long start = System.currentTimeMillis();
    try {
      return methodInvocation.proceed();
    } finally {
      log.info("监控 - Begin By AOP");
      log.info("方法名称: {}", methodInvocation.getMethod().getName());
      log.info("方法耗时: {} ms", (System.currentTimeMillis() - start));
      log.info("监控 - End");
    }
  }
}
