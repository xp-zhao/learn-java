package org.learn.spring.v17.bean;

import java.time.LocalDate;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
public class Husband {
  private String wifiName;
  private LocalDate marriageDate;

  public String getWifiName() {
    return wifiName;
  }

  public void setWifiName(String wifiName) {
    this.wifiName = wifiName;
  }

  public LocalDate getMarriageDate() {
    return marriageDate;
  }

  public void setMarriageDate(LocalDate marriageDate) {
    this.marriageDate = marriageDate;
  }

  @Override
  public String toString() {
    return "Husband{" + "wifiName='" + wifiName + '\'' + ", marriageDate=" + marriageDate + '}';
  }
}
