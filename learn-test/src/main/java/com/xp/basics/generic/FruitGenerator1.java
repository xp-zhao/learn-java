package com.xp.basics.generic;

/**
 * @description: 实现泛型接口，传入泛型实参
 * @author: zhaoxiaoping
 * @create: 2019/06/25
 **/
public class FruitGenerator1 implements GenericInterface<String> {

  @Override
  public String next() {
    return "hello";
  }
}