package com.xp.salarypay.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * WeeklyPay.java 每周五支付
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public class WeeklyPay implements PayDate {

  @Override
  public boolean isPayDate(LocalDate date) {
    DayOfWeek day = date.getDayOfWeek();
    return DayOfWeek.FRIDAY.equals(day);
  }

  @Override
  public LocalDate getPayPeriodStartDate(LocalDate date) {
    // 本周第一天
    return date.with(DayOfWeek.MONDAY);
  }
}