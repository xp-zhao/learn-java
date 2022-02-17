package org.learn.spring.beans;

import java.lang.reflect.Method;
import org.learn.spring.aop.MethodBeforeAdvice;

/**
 * @author zhaoxiaoping
 * @date 2022-2-17
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

  @Override
  public void before(Method method, Object[] args, Object target) throws Throwable {
    System.out.println("拦截方法：" + method.getName());
  }
}
