package com.xp.dynamic;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-16
 **/
public class Client {

  public static void main(String[] args) {
    // 真实角色
    Host host = new Host();
    // 代理角色
    ProxyInvocationHandler handler = new ProxyInvocationHandler();
    // 通过调用程序处理角色，来处理我们要调用的接口对象
    handler.setRent(host);
    Rent proxy = (Rent) handler.getProxy();
    proxy.rent("成都");
  }

}
