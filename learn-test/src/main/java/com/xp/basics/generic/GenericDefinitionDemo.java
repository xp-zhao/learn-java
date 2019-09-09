package com.xp.basics.generic;

/**
 * <pre>
 * GenericDefinitionDemo.java 泛型示例
 * 1. 尖括号里面每个元素都代表一种未知元素
 * 2. 尖括号的位置必须在类名之后或者方法返回值之前
 * 3. 泛型在定义处，只具备执行 Object 方法的能力
 * 4. 编译之后的字节码会进行类型擦除
 * </pre>
 * @author: zhaoxiaoping
 * @date: 2019/09/09
 **/
public class GenericDefinitionDemo<T> {

  static <String, T, Alibaba> String get(String string, Alibaba alibaba){
    return string;
  }

  public static void main(String[] args) {
    Integer first = 222;
    Long second = 333L;
    Integer result = get(first, second);
    System.out.println(result);
  }
}