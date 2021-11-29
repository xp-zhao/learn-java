package com.design.design_2_02.factory.impl;

import com.design.design_2_00.matter.IIR;
import com.design.design_2_02.factory.ICacheAdapter;
import java.util.concurrent.TimeUnit;

/**
 * 集群 B
 *
 * @author lenovo
 * @date 2021/11/26
 */
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
