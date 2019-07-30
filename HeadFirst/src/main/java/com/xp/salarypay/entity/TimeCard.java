package com.xp.salarypay.entity;

import java.time.LocalDate;
import lombok.Data;

/**
 * TimeCard.java 工作时间卡
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/30
 **/
@Data
public class TimeCard {

  /**
   * 工作日期
   */
  private LocalDate date;
  /**
   * 工作时间
   */
  private int hours;
}