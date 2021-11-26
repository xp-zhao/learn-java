package com.xp.creator.abstractfactory.common.matter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 机器 B
 * @Date 2021-4-28
 **/
@Slf4j
public class IIR {

  private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

  public String get(String key) {
    log.info("IIR获取数据 key：{}", key);
    return dataMap.get(key);
  }

  public void set(String key, String value) {
    log.info("IIR写入数据 key：{} val：{}", key, value);
    dataMap.put(key, value);
  }

  public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
    log.info("IIR写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout,
        timeUnit.toString());
    dataMap.put(key, value);
  }

  public void del(String key) {
    log.info("IIR删除数据 key：{}", key);
    dataMap.remove(key);
  }
}
