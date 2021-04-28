package com.xp.ProxyMode.proxy;

import java.lang.reflect.Proxy;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/12
 **/
public class Client {

  public static void main(String[] args) {
    IHelloWorld hw = new HelloWorld();
    LoggerHandler handler = new LoggerHandler(hw);

    // 生成代理类
    IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
        hw.getClass().getInterfaces(), handler);
    proxy.sayHello();
  }
}