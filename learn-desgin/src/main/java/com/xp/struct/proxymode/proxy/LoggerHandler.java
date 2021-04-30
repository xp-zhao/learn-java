package com.xp.struct.proxymode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * LoggerHandler.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/12
 **/
public class LoggerHandler implements InvocationHandler {

  private Object target;

  public LoggerHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("记录日志开始");
    Object result = method.invoke(target, args);
    System.out.println("记录日志结束");
    return result;
  }
}