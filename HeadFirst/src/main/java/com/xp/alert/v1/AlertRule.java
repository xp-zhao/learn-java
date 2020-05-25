package com.xp.alert.v1;

/**
 * @author zhaoxiaoping
 * @Description: 告警规则
 * @Date 2020/5/21
 **/
public class AlertRule {

  long maxTps;
  long maxErrorCount;

  public AlertRule getMatchRule(String api) {
    return new AlertRule();
  }

  public long getMaxTps() {
    return maxTps;
  }

  public void setMaxTps(long maxTps) {
    this.maxTps = maxTps;
  }

  public long getMaxErrorCount() {
    return maxErrorCount;
  }

  public void setMaxErrorCount(long maxErrorCount) {
    this.maxErrorCount = maxErrorCount;
  }
}
