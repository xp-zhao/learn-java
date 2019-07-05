package com.xp.basics.finaltest;

/**
 * FinalDemo.java final 关键词测试
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/05
 **/
public class FinalDemo {

  public static void main(String[] args) {
    int n1 = 2019;
    // final 关键字修饰的常量会在编译期放到常量池，n2 直接放入常量池
    final int n2 = 2019;

    // s 也会放入常量池
    String s = "20190705";
    // n1 未在常量池中，不能直接拼接
    String s1 = n1 + "0705";
    // n2 已经在常量池中，直接拼接成 20190705，此时系统发现字符串常量池中已经存在 20190705 直接返回对应的引用
    String s2 = n2 + "0705";

    // false
    System.out.println(s1 == s);
    // true
    System.out.println(s2 == s);
  }
}