package com.xp.alert.v2;

import com.xp.alert.v1.AlertRule;
import com.xp.alert.v1.Notification;
import com.xp.alert.v1.NotificationEmergencyLevel;

/**
 * @author zhaoxiaoping
 * @Description: Tps 告警处理
 * @Date 2020-5-25
 **/
public class TpsAlertHandler extends AlertHandler {

  public TpsAlertHandler(AlertRule rule, Notification notification) {
    super(rule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
    long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
    if (tps > rule.getMaxTps()) {
      notification.notice(NotificationEmergencyLevel.URGENCY, "...");
    }
  }
}
