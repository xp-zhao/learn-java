package com.xp.creator.abstractfactory.v2.factory;

import com.xp.creator.abstractfactory.v2.util.ClassLoaderUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhaoxiaoping
 * @Description: 动态代理
 * @Date 2021-4-29
 **/
public class JDKInvocationHandler implements InvocationHandler {

  private ICacheAdapter cacheAdapter;
  

  public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
    this.cacheAdapter = cacheAdapter;
  }

  public void setCacheAdapter(ICacheAdapter cacheAdapter) {
    this.cacheAdapter = cacheAdapter;
  }

  public <T> T getProxy(Class<T> interfaceClass) {
    ClassLoader classLoader = this.getClass().getClassLoader();

    return (T) Proxy.newProxyInstance(classLoader, interfaceClass.getInterfaces(), this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args))
        .invoke(cacheAdapter, args);
  }
}
