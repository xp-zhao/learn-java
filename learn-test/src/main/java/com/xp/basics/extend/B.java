package com.xp.basics.extend;

/**
 * A.java 多态示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/31
 **/
public class B extends A {

  public String show(B obj) {
    return "B and B";
  }

  @Override
  public String show(A obj){
    return "B and A";
  }
}