package com.xp.salarypay.entity;

import com.xp.salarypay.pay.PayMethod;
import com.xp.salarypay.pay.PayStrategy;
import com.xp.salarypay.reduce.Reduce;
import com.xp.salarypay.schedule.PayDate;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee.java 雇员的公共父类
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
@Data
@NoArgsConstructor
public class Employee {

  private String id;
  private String name;
  private Integer age;
  private Integer sex;
  /**
   * 支付策略（每天支付，每周支付，销售分成）
   */
  private PayStrategy payStrategy;
  /**
   * 支付时间抽象
   */
  private PayDate payDate;
  /**
   * 支付方式
   */
  private PayMethod payMethod;
  /**
   * 扣除项
   */
  private Reduce reduce;

  public Employee(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public boolean isPayDay(LocalDate date) {
    return this.payDate.isPayDate(date);
  }

  public LocalDate getStartDate(LocalDate date){
    return this.payDate.getPayPeriodStartDate(date);
  }

  public void payDay(PayDetail detail){
    double grossPay = payStrategy.calculatePay(detail);
    double deductions = reduce.calculateDeductions(detail);
    double netPay = grossPay - deductions;
    detail.setGrossPay(grossPay);
    detail.setDeductions(deductions);
    detail.setNetPay(netPay);
    payMethod.pay(detail);
  }
}