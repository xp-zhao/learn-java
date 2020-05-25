package com.xp.alert.v2;

import com.xp.alert.v1.AlertRule;
import com.xp.alert.v1.Notification;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-5-25
 **/
public class ApplicationContext {

  private AlertRule rule;
  private Notification notification;
  private Alert alert;

  public void initializeBeans() {
    rule = new AlertRule();
    notification = new Notification();
    alert = new Alert();
    alert.addAlertHandler(new TpsAlertHandler(rule, notification));
    alert.addAlertHandler(new ErrorAlertHandler(rule, notification));
    alert.addAlertHandler(new TimeoutAlertHandler(rule, notification));
  }

  public Alert getAlert() {
    return alert;
  }

  private static final ApplicationContext instance = new ApplicationContext();

  private ApplicationContext() {
    instance.initializeBeans();
  }

  public static ApplicationContext getInstance() {
    return instance;
  }
}
