package com.xp.basics.generic;

/**
 * @description: 泛型类 (T 可以写成任意标识，如 E、K、V 等)
 * @author: zhaoxiaoping
 * @create: 2019/06/24
 **/
public class GenericClass<T> {

  /**
   * 这个成员变量的类型为 T，T 的类型由外部指定
   */
  private T key;

  public GenericClass(){
    super();
  }

  public GenericClass(T key) {
    this.key = key;
  }

  public T getKey() {
    return key;
  }

  public static void main(String[] args) {

    // 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
    GenericClass<Integer> genericInteger = new GenericClass(12345);
    GenericClass genericString = new GenericClass("hello");

    System.out.println("泛型测试, key is " + genericInteger.getKey());
    System.out.println("泛型测试, key is " + genericString.getKey());

    GenericClass<Integer> generic = new GenericClass<>(1);
    new GenericClass<>().showKeyValue(generic);
    new GenericClass<>().showKeyValue(genericString);
  }

  public void showKeyValue(GenericClass<? extends Number> obj){
    System.out.println("泛型测试: key value is " + obj.getKey());
  }
}