package com.xp.alert.v2;

import com.xp.alert.v1.AlertRule;
import com.xp.alert.v1.Notification;

/**
 * @author zhaoxiaoping
 * @Description: 超时告警
 * @Date 2020-5-25
 **/
public class TimeoutAlertHandler extends AlertHandler {

  public TimeoutAlertHandler(AlertRule rule,
      Notification notification) {
    super(rule, notification);
  }

  @Override
  public void check(ApiStatInfo apiStatInfo) {
      
  }
}
