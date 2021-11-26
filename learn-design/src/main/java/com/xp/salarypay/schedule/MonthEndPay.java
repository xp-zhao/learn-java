package com.xp.salarypay.schedule;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * MonthEndPay.java 月底支付
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public class MonthEndPay implements PayDate {

  @Override
  public boolean isPayDate(LocalDate date) {
    // 本月最后一天
    LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
    return date.equals(lastDay);
  }

  @Override
  public LocalDate getPayPeriodStartDate(LocalDate date) {
    // 本月第一天
    return date.with(TemporalAdjusters.firstDayOfMonth());
  }
}