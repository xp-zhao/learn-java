package com.xp.struct.adapter.v2;

import com.alibaba.fastjson.JSON;
import java.util.Map;

/**
 * @author zhaoxiaoping
 * @Description: 消息适配
 * @Date 2021-4-30
 **/
public class MqAdapter {

  public static RebateInfo filter(String json, Map<String, String> link) {
    return fileter(JSON.parseObject(json, Map.class), link);
  }

  public static RebateInfo fileter(Map obj, Map<String, String> link) {
    RebateInfo rebateInfo = new RebateInfo();
    link.forEach((k, v) -> {
      Object val = obj.get(v);
      try {
        RebateInfo.class
            .getMethod("set" + k.substring(0, 1).toUpperCase() + k.substring(1), String.class)
            .invoke(rebateInfo, val.toString());
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    return rebateInfo;
  }
}
