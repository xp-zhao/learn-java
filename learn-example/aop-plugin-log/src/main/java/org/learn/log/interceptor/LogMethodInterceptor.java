package org.learn.log.interceptor;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 日志方法拦截器
 *
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@Slf4j
public class LogMethodInterceptor implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    Object result;
    try {
      result = invocation.proceed();
    } finally {
      log.info(
          "TargetClass:【{}】,method:【{}】,args:【{}】",
          invocation.getThis().getClass().getName(),
          invocation.getMethod().getName(),
          Arrays.toString(invocation.getArguments()));
    }
    return result;
  }
}
