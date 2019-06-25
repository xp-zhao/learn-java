package com.xp.basics.generic;

/**
 * @description: 实现泛型接口，不传入泛型实参
 * @author: zhaoxiaoping
 * @create: 2019/06/24
 **/
public class FruitGenerator<T> implements GenericInterface<T> {

  @Override
  public T next() {
    return null;
  }
}