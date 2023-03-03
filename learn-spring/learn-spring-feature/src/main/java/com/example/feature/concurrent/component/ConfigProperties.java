package com.example.feature.concurrent.component;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置
 *
 * @author zhaoxiaoping
 * @date 2023-3-2
 */
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {
  private Integer threadNum;
  private Integer period;
  private Integer queueSizeLimit;
  private Integer capacity;

  public Integer getThreadNum() {
    return threadNum;
  }

  public void setThreadNum(Integer threadNum) {
    this.threadNum = threadNum;
  }

  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public Integer getQueueSizeLimit() {
    return queueSizeLimit;
  }

  public void setQueueSizeLimit(Integer queueSizeLimit) {
    this.queueSizeLimit = queueSizeLimit;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
}
