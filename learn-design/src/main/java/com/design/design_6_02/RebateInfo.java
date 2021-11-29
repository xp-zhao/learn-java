package com.design.design_6_02;

import java.util.Date;
import lombok.Data;

/**
 * 统一的 mq 消息体
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
public class RebateInfo {
  /** 用户ID */
  private String userId;

  /** 业务ID */
  private String bizId;

  /** 业务时间 */
  private Date bizTime;

  /** 业务描述 */
  private String desc;

  public void setBizTime(String bizTime) {
    this.bizTime = new Date(Long.parseLong("1591077840669"));
  }

  public void setBizTime(Date bizTime) {
    this.bizTime = bizTime;
  }
}
