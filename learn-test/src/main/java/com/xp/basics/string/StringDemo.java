package com.xp.basics.string;

import java.util.StringJoiner;

/**
 * StringDemo.java String 学习
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/27
 **/
public class StringDemo {

  public static void main(String[] args) {
    String s = new String("1");
    s.intern();
    String s2 = "1";
    System.out.println(s == s2);

    String s3 = new String("1") + new String("1");
    s3.intern();
    String s4 = "11";
    System.out.println(s3 == s4);

    /**
     * StringJoiner 拼接字符串
     */
    StringJoiner sj = new StringJoiner(":");
    sj.add("cd");
    sj.add("ef");
    System.out.println(sj.toString());

    StringJoiner sj1 = new StringJoiner(":", "[", "]");
    sj1.add("a");
    sj1.add("b");
    sj1.add("c");
    System.out.println(sj1.toString());
  }
}