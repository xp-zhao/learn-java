package com.xp.alert.v2;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 参数对象
 * @Date 2020-5-25
 **/
@Data
public class ApiStatInfo {

  private String api;
  private long requestCount;
  private long errorCount;
  private long durationOfSeconds;
  private long timeoutCount;
}
