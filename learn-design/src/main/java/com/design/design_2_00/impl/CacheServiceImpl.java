package com.design.design_2_00.impl;

import com.xp.creator.abstractfactory.common.CacheService;
import com.xp.creator.abstractfactory.common.RedisUtils;
import java.util.concurrent.TimeUnit;

/**
 * 缓存实现
 *
 * @author zhaoxiaoping
 * @date 2021-4-28
 */
public class CacheServiceImpl implements CacheService {

  private RedisUtils redisUtils = new RedisUtils();

  @Override
  public String get(String key) {
    return redisUtils.get(key);
  }

  @Override
  public void set(String key, String value) {
    redisUtils.set(key, value);
  }

  @Override
  public void set(String key, String value, long timeout, TimeUnit timeUnit) {
    redisUtils.set(key, value, timeout, timeUnit);
  }

  @Override
  public void del(String key) {
    redisUtils.del(key);
  }
}
