package com.xp.creator.abstractfactory.v2.impl;

import com.xp.creator.abstractfactory.common.RedisUtils;
import com.xp.creator.abstractfactory.v2.CacheService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 缓存实现
 * @Date 2021-4-28
 **/
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
