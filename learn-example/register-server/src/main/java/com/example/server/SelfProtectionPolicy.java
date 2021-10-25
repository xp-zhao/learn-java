package com.example.server;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/** @author zhaoxiaoping @Description: 自我保护机制 @Date 2021-10-22 */
@Getter
@Setter
@Slf4j
public class SelfProtectionPolicy {

  private static SelfProtectionPolicy instance = new SelfProtectionPolicy();

  /** 期望的心跳次数 (如果有 10 个服务实例, 这个数值就是 10 * 2 = 20) */
  private long expectedHeartbeatRate;
  /** 期望的心跳次数阈值 (10 * 2 * 0.85 = 17, 每分钟至少得有 17 次心跳, 才不用进入自我保护机制) */
  private long expectedHeartbeatThreshold;

  public static SelfProtectionPolicy getInstance() {
    return instance;
  }

  public Boolean isEnable() {
    HeartbeatMeasuredRate heartbeatMeasuredRate = HeartbeatMeasuredRate.getInstance();
    long latestMinuteHeartbeatRate = heartbeatMeasuredRate.getLatestMinuteHeartbeatRate();
    if (latestMinuteHeartbeatRate < this.expectedHeartbeatThreshold) {
      log.info(
          "[自我保护机制开启], 最近一分钟心跳次数: {}, 期望心跳次数: {}",
          latestMinuteHeartbeatRate,
          expectedHeartbeatRate);
      return true;
    }
    log.info(
        "[自我保护机制未开启], 最近一分钟心跳次数: {}, 期望心跳次数: {}", latestMinuteHeartbeatRate, expectedHeartbeatRate);
    return false;
  }
}
