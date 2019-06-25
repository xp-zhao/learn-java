package com.xp.basics.generic;

/**
 * @description: 泛型方法
 * @author: zhaoxiaoping
 * @create: 2019/06/25
 **/
public class GenericMethod {

  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Object object = genericMethod(Class.forName("com.xp.basics.generic.GenericMethod"));
  }

  public static <T> T genericMethod(Class<T> tClass)
      throws IllegalAccessException, InstantiationException {
    T instance = tClass.newInstance();
    return instance;
  }
}