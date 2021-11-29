package com.design.design_2_02.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class JDKProxy {
  public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) {
    InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    Class<?>[] classes = interfaceClass.getInterfaces();
    return (T) Proxy.newProxyInstance(classLoader, new Class[] {classes[0]}, handler);
  }
}
