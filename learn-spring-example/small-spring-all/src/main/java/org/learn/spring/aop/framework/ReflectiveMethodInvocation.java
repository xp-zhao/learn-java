package org.learn.spring.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

  /** 目标对象 */
  protected final Object target;
  /** 方法 */
  protected final Method method;
  /** 入参 */
  protected final Object[] arguments;

  public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
    this.target = target;
    this.method = method;
    this.arguments = arguments;
  }

  @Override
  public Method getMethod() {
    return method;
  }

  @Override
  public Object[] getArguments() {
    return arguments;
  }

  @Override
  public Object proceed() throws Throwable {
    return method.invoke(target, arguments);
  }

  @Override
  public Object getThis() {
    return target;
  }

  @Override
  public AccessibleObject getStaticPart() {
    return method;
  }
}
