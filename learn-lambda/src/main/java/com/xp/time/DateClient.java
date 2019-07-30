package com.xp.time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * DateClient.java java8 时间api
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public class DateClient {

  public static void main(String[] args) {
    LocalDate date = LocalDate.now();
    // 当前月的最后一天
    LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
    System.out.println(date);
    // 当前日期前两周的日期
    System.out.println(date.plusWeeks(-2L));
    System.out.println(lastDay);
    System.out.println(LocalDate.of(2019,7,30).equals(lastDay));
  }
}