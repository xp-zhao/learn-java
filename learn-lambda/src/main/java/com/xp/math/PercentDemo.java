package com.xp.math;

/**
 * @description: 计算百分比
 * @author: zhaoxp
 * @create: 2019/05/06
 **/
public class PercentDemo {

  public static void main(String[] args) {
    System.out.println(calculate(3,4));
  }

  public static int calculate(int a, int b){
    double x = a * 1.0;
    double y = b * 1.0;
    return (int) ((x / y) * 100);
  }
}