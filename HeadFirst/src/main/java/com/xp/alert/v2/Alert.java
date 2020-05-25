package com.xp.alert.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @Description: 告警
 * @Date 2020-5-25
 **/
public class Alert {

  private List<AlertHandler> alertHandlers = new ArrayList<>();

  public void addAlertHandler(AlertHandler alertHandler) {
    this.alertHandlers.add(alertHandler);
  }

  public void check(ApiStatInfo apiStatInfo) {
    for (AlertHandler alertHandler : alertHandlers) {
      alertHandler.check(apiStatInfo);
    }
  }
}
