package com.xp.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @Description: 使用这个类动态生成代理类
 * @Date 2020-9-16
 **/
public class ProxyInvocationHandler implements InvocationHandler {

  /**
   * 被代理的接口
   */
  private Rent rent;

  public void setRent(Rent rent) {
    this.rent = rent;
  }

  /**
   * 生成代理类
   *
   * @return
   */
  public Object getProxy() {
    return Proxy
        .newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
  }

  /**
   * 处理代理实例，并返回结果
   *
   * @param proxy
   * @param method
   * @param args
   * @return
   * @throws Throwable
   */
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 动态代理的本质，就是使用反射机制实现
    Object result = method.invoke(rent, args);
    System.out.println("args: " + Arrays.toString(args));
    System.out.println("result: " + result);
    return result;
  }
}
