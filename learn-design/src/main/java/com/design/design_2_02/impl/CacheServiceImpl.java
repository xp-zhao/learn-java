package com.design.design_2_02.impl;

import com.design.design_2_00.RedisUtils;
import com.design.design_2_02.CacheService;
import java.util.concurrent.TimeUnit;

/**
 * 缓存实现
 *
 * @author zhaoxiaoping @Date 2021-4-28
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
