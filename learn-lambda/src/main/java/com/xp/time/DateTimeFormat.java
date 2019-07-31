package com.xp.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 * DateTimeFormat.java 时间格式验证
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/31
 **/
public class DateTimeFormat {

  public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd".replace("y","u")).withResolverStyle(
        ResolverStyle.STRICT);
    formatter.parse("2019-02-28");
//    formatter.parse("2019-02-30");
    System.out.println(LocalDate.parse("2019-02-28", formatter));
    System.out.println(LocalDate.parse("2019-02-30", formatter));
  }
}