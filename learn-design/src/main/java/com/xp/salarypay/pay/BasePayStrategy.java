package com.xp.salarypay.pay;

import com.xp.salarypay.entity.PayDetail;

/**
 * BasePayStrategy.java 固定薪水支付策略
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
public class BasePayStrategy implements PayStrategy {

  private double salary;

  public BasePayStrategy(double salary) {
    this.salary = salary;
  }

  @Override
  public double calculatePay(PayDetail detail) {
    return salary;
  }
}