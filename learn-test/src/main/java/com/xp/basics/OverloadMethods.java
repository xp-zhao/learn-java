package com.xp.basics;


/**
 * <pre>
 * OverloadMethods.java 方法重载示例
 * 重载方法，目标方法寻找顺序：
 *  1. 精确匹配
 *  2. 如果是基本数据类型，自动转换为更大表示范围的基本类型
 *  3. 通过自动拆箱与装箱
 *  4. 通过子类向上转型继承路线依次匹配
 *  5. 通过可变参数匹配
 * </pre>
 * @author: zhaoxiaoping
 * @date: 2019/09/09
 **/
public class OverloadMethods {

  public static void main(String[] args) {
    OverloadMethods methods = new OverloadMethods();
    methods.methodForOverload(7);
  }

  public void overloadMethod(){
    System.out.println("无参方法");
  }

  public void methodForOverload(int param){
    System.out.println("参数为基本类型 int 的方法");
  }

  public void methodForOverload(Integer param){
    System.out.println("参数为包装类型 Integer 的方法");
  }

  public void methodForOverload(Integer ...param){
    System.out.println("可变参数");
  }

  public void methodForOverload(Object param){
    System.out.println("参数为 Object 的方法");
  }
}