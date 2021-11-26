package com.xp.alert.v2;

import com.xp.alert.v1.AlertRule;
import com.xp.alert.v1.Notification;
import com.xp.alert.v1.NotificationEmergencyLevel;

/**
 * @author zhaoxiaoping
 * @Description: 错误告警处理器
 * @Date 2020-5-25
 **/
public class ErrorAlertHandler extends AlertHandler {

  public ErrorAlertHandler(AlertRule rule,
      Notification notification) {
    super(rule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
    if (apiStatInfo.getErrorCount() > rule.getMaxErrorCount()) {
      notification.notice(NotificationEmergencyLevel.SEVERE, "...");
    }
  }
}
