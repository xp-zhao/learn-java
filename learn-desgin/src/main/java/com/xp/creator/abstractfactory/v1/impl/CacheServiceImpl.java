package com.xp.creator.abstractfactory.v1.impl;

import com.xp.creator.abstractfactory.common.RedisUtils;
import com.xp.creator.abstractfactory.common.matter.EGM;
import com.xp.creator.abstractfactory.common.matter.IIR;
import com.xp.creator.abstractfactory.v1.CacheService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 缓存实现
 * @Date 2021-4-28
 **/
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
