package org.example;

/**
 * @author xp-zhao
 * @description
 * @date 2023/10/9 22:39
 */
public class HelloServiceImpl implements HelloService {

  @Override
  public String sayHello(String name) {
    return "hello " + name;
  }
}
