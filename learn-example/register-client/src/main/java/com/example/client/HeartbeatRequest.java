package com.example.client;

import lombok.Data;
import lombok.ToString;

/** @author zhaoxiaoping @Description: 心跳请求 @Date 2021-10-13 */
@Data
@ToString
public class HeartbeatRequest {
  /** 服务实例id */
  private String serviceInstanceId;
}
