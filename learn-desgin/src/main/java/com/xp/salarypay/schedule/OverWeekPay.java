package com.xp.salarypay.schedule;

import java.time.LocalDate;
import java.time.Period;

/**
 * OverWeekPay.java 隔周支付
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public class OverWeekPay implements PayDate {

  LocalDate firstPayableFriday = LocalDate.of(2017, 6, 2);

  @Override
  public boolean isPayDate(LocalDate date) {
    Period period = Period.between(firstPayableFriday, date);
    return period.getDays() % 14 == 0;
  }

  @Override
  public LocalDate getPayPeriodStartDate(LocalDate date) {
    return date.plusWeeks(-2L);
  }
}