package com.xp.creator.abstractfactory.common;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 缓存服务
 * @Date 2021-4-28
 **/
public interface CacheService {

  /**
   * 获取缓存
   *
   * @param key key
   * @return 对应的值
   */
  String get(final String key);

  /**
   * 设置缓存
   *
   * @param key   key
   * @param value value
   */
  void set(String key, String value);

  /**
   * 设置带过去时间的缓存
   *
   * @param key      key
   * @param value    value
   * @param timeout  过期时间
   * @param timeUnit 时间单位
   */
  void set(String key, String value, long timeout, TimeUnit timeUnit);

  /**
   * 删除缓存
   *
   * @param key key
   */
  void del(String key);
}
