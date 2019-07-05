package com.xp.basics.finaltest;

/**
 * Outter.java 匿名内部类 final 测试
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/05
 **/
public class Outter {

  public static void main(String[] args) {
    final int a = 100;
    new Thread(() -> System.out.println(a)).start();
  }
}