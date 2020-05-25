package com.xp.alert.v2;

import com.xp.alert.v1.AlertRule;
import com.xp.alert.v1.Notification;

/**
 * @author zhaoxiaoping
 * @Description: 告警处理器
 * @Date 2020-5-25
 **/
public abstract class AlertHandler {

  protected AlertRule rule;
  protected Notification notification;

  public AlertHandler(AlertRule rule, Notification notification) {
    this.rule = rule;
    this.notification = notification;
  }

  /**
   * 告警检查方法
   *
   * @param apiStatInfo
   */
  public abstract void check(ApiStatInfo apiStatInfo);
}
