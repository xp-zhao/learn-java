package com.xp.salarypay.schedule;

import java.time.LocalDate;

/**
 * 支付日期接口
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public interface PayDate {

  boolean isPayDate(LocalDate date);

  LocalDate getPayPeriodStartDate(LocalDate date);
}
