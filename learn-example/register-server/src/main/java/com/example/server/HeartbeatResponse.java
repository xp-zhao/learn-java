package com.example.server;

import lombok.Data;

/** @author zhaoxiaoping @Description: 心跳响应 @Date 2021-10-13 */
@Data
public class HeartbeatResponse {
  public static final String SUCCESS = "success";
  public static final String FAILURE = "failure";
  private String status;
}
