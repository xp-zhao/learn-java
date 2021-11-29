package com.design.design_2_01.impl;

import com.design.design_2_00.RedisUtils;
import com.design.design_2_00.matter.EGM;
import com.design.design_2_00.matter.IIR;
import com.design.design_2_01.CacheService;
import java.util.concurrent.TimeUnit;

/**
 * 缓存实现
 *
 * @author zhaoxiaoping
 * @date 2021-4-28
 */
public class CacheServiceImpl implements CacheService {

  private RedisUtils redisUtils = new RedisUtils();

  private EGM egm = new EGM();

  private IIR iir = new IIR();

  @Override
  public String get(String key, int redisType) {
    if (1 == redisType) {
      return egm.gain(key);
    }
    if (2 == redisType) {
      return iir.get(key);
    }
    return redisUtils.get(key);
  }

  @Override
  public void set(String key, String value, int redisType) {
    if (1 == redisType) {
      egm.set(key, value);
      return;
    }
    if (2 == redisType) {
      iir.set(key, value);
      return;
    }
    redisUtils.set(key, value);
  }

  @Override
  public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
    if (1 == redisType) {
      egm.setEx(key, value, timeout, timeUnit);
      return;
    }
    if (2 == redisType) {
      iir.setExpire(key, value, timeout, timeUnit);
      return;
    }
    redisUtils.set(key, value, timeout, timeUnit);
  }

  @Override
  public void del(String key, int redisType) {
    if (1 == redisType) {
      egm.delete(key);
      return;
    }
    if (2 == redisType) {
      iir.del(key);
      return;
    }
    redisUtils.del(key);
  }
}
