package com.design.design_6_00.mq;

import java.util.Date;
import lombok.Data;

/**
 * 开户
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
public class CreateAccount {
  /** 开户编号 */
  private String number;

  /** 开户地 */
  private String address;

  /** 开户时间 */
  private Date accountDate;

  /** 开户描述 */
  private String desc;
}
