package com.design.design_2_02.factory;

import java.util.concurrent.TimeUnit;

/**
 * 缓存适配接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
public interface ICacheAdapter {
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
   * @param key key
   * @param value value
   */
  void set(String key, String value);

  /**
   * 设置带过去时间的缓存
   *
   * @param key key
   * @param value value
   * @param timeout 过期时间
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
