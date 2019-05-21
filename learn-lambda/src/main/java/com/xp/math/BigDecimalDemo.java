package com.xp.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @description: 小数计算
 * @author: zhaoxp
 * @create: 2019/05/21
 **/
public class BigDecimalDemo {

  public static void main(String[] args) {
    String str = "65.55";
    BigDecimal num = new BigDecimal(str);
    System.out.println(num);
    double a = 1;
    double b = 13;
    DecimalFormat df = new DecimalFormat("0.00%");
    System.out.println(df.format(a/b));
  }
}