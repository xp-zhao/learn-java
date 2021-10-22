package com.example.client;

import lombok.Data;
import lombok.Getter;

/** @author zhaoxiaoping @Description: 服务实例 @Date 2021-10-13 */
@Data
public class ServiceInstance {

  /** 判断一个服务不在存活的周期 */
  private static final Long NOT_ALIVE_PERIOD = 90 * 1000L;
  /** 服务名称 */
  private String serviceName;
  /** ip地址 */
  private String ip;
  /** 端口号 */
  private int port;
  /** 主机名 */
  private String hostname;
  /** 服务实例id */
  private String serviceInstanceId;

  public ServiceInstance() {
  }
 
}
