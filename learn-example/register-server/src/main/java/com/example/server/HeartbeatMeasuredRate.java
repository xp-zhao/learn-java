package com.example.server;

/** @author zhaoxiaoping @Description: 心跳计数器 @Date 2021-10-22 */
public class HeartbeatMeasuredRate {
  private HeartbeatMeasuredRate instance = new HeartbeatMeasuredRate();

  /** 最近一分钟心跳次数 */
  private long latestMinuteHeartbeatRate = 0L;
  /** 最近一分钟的时间戳 */
  private long latestMinuteTimestamp = 0L;

  public HeartbeatMeasuredRate getInstance() {
    return instance;
  }

  /** 增加一次最近一分钟的心跳次数 */
  public synchronized void increment() {
    long currentTime = System.currentTimeMillis();
    if (currentTime - latestMinuteTimestamp > 60 * 1000L) {
      latestMinuteHeartbeatRate = 0L;
      this.latestMinuteTimestamp = System.currentTimeMillis();
    }
    latestMinuteHeartbeatRate++;
  }

  /**
   * 获取最近一分钟的心跳次数
   *
   * @return
   */
  public synchronized long getLatestMinuteHeartbeatRate() {
    return latestMinuteHeartbeatRate;
  }
}
