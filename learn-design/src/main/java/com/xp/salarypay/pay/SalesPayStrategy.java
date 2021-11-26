package com.xp.salarypay.pay;

import com.xp.salarypay.entity.PayDetail;
import com.xp.salarypay.entity.SalesReceipt;
import java.time.LocalDate;
import java.util.Map;

/**
 * SalesPayStrategy.java 销售类支付策略
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public class SalesPayStrategy implements PayStrategy {

  double salary;
  double rate;
  Map<LocalDate, SalesReceipt> receipts;

  public SalesPayStrategy(double salary, double rate) {
    this.salary = salary;
    this.rate = rate;
  }

  @Override
  public double calculatePay(PayDetail detail) {
    double commission = 0.0;
    for (SalesReceipt receipt : receipts.values()) {
      if (receipt.getSaleDate().isAfter(detail.getStart()) && receipt.getSaleDate()
          .isBefore(detail.getEnd())) {
        commission += receipt.getAmount() * rate;
      }
    }
    return salary + commission;
  }
}