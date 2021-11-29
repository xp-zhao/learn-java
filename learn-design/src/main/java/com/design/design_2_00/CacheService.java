package com.design.design_2_00;

import java.util.concurrent.TimeUnit;

/**
 * 缓存服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
public interface CacheService {
  /**
   * 获取缓存
   *
   * @param key key
   * @param redisType 类型
   * @return 对应的值
   */
  String get(final String key, int redisType);

  /**
   * 设置缓存
   *
   * @param key key
   * @param value value
   * @param redisType 类型
   */
  void set(String key, String value, int redisType);

  /**
   * 设置带过去时间的缓存
   *
   * @param key key
   * @param value value
   * @param timeout 过期时间
   * @param timeUnit 时间单位
   * @param redisType 类型
   */
  void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

  /**
   * 删除缓存
   *
   * @param key key
   * @param redisType 类型
   */
  void del(String key, int redisType);
}
