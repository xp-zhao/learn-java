package com.example.server;

import lombok.Data;
import lombok.Getter;

/** @author zhaoxiaoping @Description: 服务实例 @Date 2021-10-13 */
@Data
public class ServiceInstance {

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
  /** 服务契约 */
  private Lease lease;

  public ServiceInstance() {
    this.lease = new Lease();
  }

  public void renew() {
    this.lease.renew();
  }

  /** 契约, 维护了一个服务实例和当前注册中心的联系(心跳时间, 创建时间) */
  @Getter
  private class Lease {

    /** 最近一次心跳时间 */
    private Long latestHeartbeatTime = System.currentTimeMillis();

    /** 续约, 发送一次心跳就相当于一次续约 */
    public void renew() {
      this.latestHeartbeatTime = System.currentTimeMillis();
      System.out.println("服务实例[" + serviceInstanceId + "], 进行续约: " + latestHeartbeatTime);
    }
  }
}
