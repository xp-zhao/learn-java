package com.xp.basics.extend;

/**
 * A.java 多态示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/31
 **/
public class A {
  public String show(D obj){
    return "A and D";
  }

  public String show(A obj){
    return "A and A";
  }
}