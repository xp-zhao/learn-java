package com.design.design_6_02;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * mq 消息体适配
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class MQAdapter {

  public static RebateInfo filter(String strJson, Map<String, String> link)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    return filter(JSON.parseObject(strJson), link);
  }

  public static RebateInfo filter(Map obj, Map<String, String> link)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    RebateInfo rebateInfo = new RebateInfo();
    for (String key : link.keySet()) {
      String val = String.valueOf(obj.get(link.get(key)));
      RebateInfo.class
          .getMethod(
              "set" + key.substring(0, 1).toUpperCase() + key.substring(1),
              String.class)
          .invoke(rebateInfo, val);
    }
    return rebateInfo;
  }
}
