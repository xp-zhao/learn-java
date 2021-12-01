package com.design.design_18_02;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 摇号结果
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
@AllArgsConstructor
public class LotteryResult {
  /** 用户ID */
  private String uId;

  /** 摇号信息 */
  private String msg;

  /** 业务时间 */
  private Date dateTime;
}
