package com.xp.alert.v1;

/**
 * @author zhaoxiaoping
 * @Description: 告警处理
 * @Date 2020/5/21
 **/
public class Alert {

  private AlertRule rule;
  private Notification notification;

  public Alert(AlertRule rule, Notification notification) {
    this.rule = rule;
    this.notification = notification;
  }

  public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
    long tps = requestCount / durationOfSeconds;
    if(tps > rule.getMatchRule(api).getMaxTps()){
      notification.notice(NotificationEmergencyLevel.URGENCY, "");
    }
    if (errorCount > rule.getMatchRule(api).getMaxErrorCount()) {
      notification.notice(NotificationEmergencyLevel.SEVERE, "");
    }
  }
}
