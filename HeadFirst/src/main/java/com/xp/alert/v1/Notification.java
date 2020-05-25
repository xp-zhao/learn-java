package com.xp.alert.v1;

/**
 * @author zhaoxiaoping
 * @Description: 通知类
 * @Date 2020/5/21
 **/
public class Notification {

  private MessageSender messageSender;

  public Notification(MessageSender messageSender) {
    this.messageSender = messageSender;
  }

  public void notice(NotificationEmergencyLevel level, String content) {
    System.out.println("通知");
  }
}
