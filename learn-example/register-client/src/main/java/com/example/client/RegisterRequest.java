package com.example.client;

import lombok.Data;
import lombok.ToString;

/** @author zhaoxiaoping @Description: 注册请求 @Date 2021-10-13 */
@Data
@ToString
public class RegisterRequest {

  /** 服务名称 */
  private String serviceName;
  /** 服务所在的 ip 地址 */
  private String ip;
  /** 主机名称 */
  private String hostname;
  /** 监听的端口号 */
  private int port;
  /** 服务实例id */
  private String serviceInstanceId;
}
