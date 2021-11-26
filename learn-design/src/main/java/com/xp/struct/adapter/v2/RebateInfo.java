package com.xp.struct.adapter.v2;

import java.util.Date;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 通用消息
 * @Date 2021-4-30
 **/
@Data
public class RebateInfo {

  private String userId;
  private String bizId;
  private Date bizTime;
  private String desc;
}
