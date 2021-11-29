package com.design.design_2_02.factory;

import com.design.design_2_02.util.ClassLoaderUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class JDKInvocationHandler implements InvocationHandler {

  private ICacheAdapter cacheAdapter;

  public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
    this.cacheAdapter = cacheAdapter;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return ICacheAdapter.class
        .getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args))
        .invoke(cacheAdapter, args);
  }
}
