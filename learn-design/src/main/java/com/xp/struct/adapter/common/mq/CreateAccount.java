package com.xp.struct.adapter.common.mq;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 创建账号通知消息
 * @Date 2021-4-30
 **/
@Data
public class CreateAccount {

  private String number;
  private String address;
  private LocalDateTime accountDate;
  private String desc;
}
