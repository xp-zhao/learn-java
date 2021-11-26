package com.xp.creator.abstractfactory.v2.factory.impl;

import com.xp.creator.abstractfactory.common.matter.IIR;
import com.xp.creator.abstractfactory.v2.factory.ICacheAdapter;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 集群 B
 * @Date 2021-4-29
 **/
public class IIRCacheAdapter implements ICacheAdapter {

  private IIR iir = new IIR();

  @Override
  public String get(String key) {
    return iir.get(key);
  }

  @Override
  public void set(String key, String value) {
    iir.set(key, value);
  }

  @Override
  public void set(String key, String value, long timeout, TimeUnit timeUnit) {
    iir.setExpire(key, value, timeout, timeUnit);
  }

  @Override
  public void del(String key) {
    iir.del(key);
  }
}
