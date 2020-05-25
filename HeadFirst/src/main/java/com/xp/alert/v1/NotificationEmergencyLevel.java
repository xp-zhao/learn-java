package com.xp.alert.v1;

/**
 * @author zhaoxiaoping
 * @Description: 通知紧急程度
 * @Date 2020/5/21
 **/
public enum NotificationEmergencyLevel {
  // 严重
  SEVERE(1, "严重"),
  // 紧急
  URGENCY(2, "紧急"),
  // 普通
  NORMAL(3, "普通"),
  // 无关紧要
  TRIVIAL(4, "无关紧要");
  private Integer code;
  private String desc;

  NotificationEmergencyLevel(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
