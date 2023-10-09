package org.example;

import org.example.proxy.ProxyFactory;

/**
 * @description $END
 * @date ${DATE} ${TIME}
 * @author xp-zhao
 */
public class Main {
  public static void main(String[] args) {
    HelloService service = ProxyFactory.getProxy(HelloService.class);
    String result = service.sayHello("xx");
    System.out.println(result);
  }
}
