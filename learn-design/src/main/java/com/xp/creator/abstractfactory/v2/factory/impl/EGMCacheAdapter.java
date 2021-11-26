package com.xp.creator.abstractfactory.v2.factory.impl;

import com.xp.creator.abstractfactory.common.matter.EGM;
import com.xp.creator.abstractfactory.v2.factory.ICacheAdapter;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 集群 A
 * @Date 2021-4-29
 **/
public class EGMCacheAdapter implements ICacheAdapter {

  private EGM egm = new EGM();

  @Override
  public String get(String key) {
    return egm.gain(key);
  }

  @Override
  public void set(String key, String value) {
    egm.set(key, value);
  }

  @Override
  public void set(String key, String value, long timeout, TimeUnit timeUnit) {
    egm.setEx(key, value, timeout, timeUnit);
  }

  @Override
  public void del(String key) {
    egm.delete(key);
  }
}
