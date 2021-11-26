package com.xp.salarypay.pay;

import com.xp.salarypay.entity.PayDetail;
import com.xp.salarypay.entity.TimeCard;
import java.time.LocalDate;
import java.util.Map;

/**
 * HourPayStrategy.java 按小时支付策略
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public class HourPayStrategy implements PayStrategy {

  private double rate;
  private Map<LocalDate, TimeCard> timeCards;

  public HourPayStrategy(double hourlyRate) {
    this.rate = hourlyRate;
  }

  public void addTimeCard(TimeCard tc) {
    timeCards.put(tc.getDate(), tc);
  }

  @Override
  public double calculatePay(PayDetail detail) {
    double totalPay = 0;
    for (TimeCard tc : timeCards.values()) {
      if (tc.getDate().isAfter(detail.getStart()) && tc.getDate().isBefore(detail.getEnd())) {
        totalPay += calculatePayForTimeCard(tc);
      }
    }
    return totalPay;
  }

  private double calculatePayForTimeCard(TimeCard tc) {
    int hours = tc.getHours();
    if (hours > 12) {
      return 12 * rate + (hours - 12) * rate * 2;
    } else {
      return 12 * rate;
    }
  }
}