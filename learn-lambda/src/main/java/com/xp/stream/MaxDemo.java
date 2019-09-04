package com.xp.stream;

import java.util.Arrays;
import java.util.List;

/**
 * MaxDemo.java 求最大值
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/30
 **/
public class MaxDemo {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    System.out.println(numbers.stream().max(Integer::compareTo).get());
    System.out.println(numbers.stream().mapToInt(i -> i).max().getAsInt());

    String name = "\"测试\"";
    System.out.println(name.replaceAll("\"", ""));
    System.out.println(name.equals("测试"));

  }
}