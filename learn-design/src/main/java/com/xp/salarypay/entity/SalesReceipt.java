package com.xp.salarypay.entity;

import java.time.LocalDate;
import lombok.Data;

/**
 * SalesReceipt.java 销售清单
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
@Data
public class SalesReceipt {

  /**
   * 销售日期
   */
  private LocalDate saleDate;
  /**
   * 销售金额
   */
  private double amount;
}