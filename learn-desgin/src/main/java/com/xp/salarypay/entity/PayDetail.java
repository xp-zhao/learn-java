package com.xp.salarypay.entity;

import java.time.LocalDate;
import java.util.Map;
import lombok.Data;

/**
 * PayDetail.java 支付详情
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
@Data
public class PayDetail {

  private LocalDate start;
  private LocalDate end;
  /**
   * 应发薪水
   */
  private double grossPay;
  /**
   * 实际发放的薪水
   */
  private double netPay;
  /**
   * 扣除的费用
   */
  private double deductions;
  private Map<String, String> itsFields;

  public PayDetail(LocalDate start, LocalDate end) {
    this.start = start;
    this.end = end;
  }
}