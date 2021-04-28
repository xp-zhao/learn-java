package com.xp.ProxyMode.proxy;

/**
 * HelloWorld.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/12
 **/
public class HelloWorld implements IHelloWorld {

  @Override
  public void sayHello() {
    System.out.println("hello world");
  }
}