package com.xp.dynamicplus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhaoxiaoping
 * @Description: 使用这个类动态生成代理类
 * @Date 2020-9-16
 **/
public class ProxyInvocationHandler implements InvocationHandler {

  /**
   * 被代理的接口
   */
  private Object target;

  public void setTarget(Object target) {
    this.target = target;
  }

  /**
   * 生成代理类
   *
   * @return
   */
  public Object getProxy() {
    return Proxy
        .newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),
            this);
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
    log(method.getName());
    Object result = method.invoke(target, args);
    return result;
  }

  private void log(String msg) {
    System.out.println("执行了" + msg + "方法");
  }
}
