package com.design.design_2_02.factory.impl;

import com.design.design_2_00.matter.EGM;
import com.design.design_2_02.factory.ICacheAdapter;
import java.util.concurrent.TimeUnit;

/**
 * 集群 A
 *
 * @author lenovo
 * @date 2021/11/26
 */
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
