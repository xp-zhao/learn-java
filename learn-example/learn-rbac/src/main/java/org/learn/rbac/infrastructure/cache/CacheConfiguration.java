package org.learn.rbac.infrastructure.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 缓存配置
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Configuration
public class CacheConfiguration {
  /** 系统默认缓存TTL时间：4分钟 一些需要用到缓存的数据，譬如支付单，需要按此数据来规划过期时间 */
  public static final long SYSTEM_DEFAULT_EXPIRES = 4 * 60 * 1000;

  @Bean
  public CacheManager configCacheManager() {
    CaffeineCacheManager manager = new CaffeineCacheManager();
    manager.setCaffeine(
        Caffeine.newBuilder().expireAfterWrite(SYSTEM_DEFAULT_EXPIRES, TimeUnit.MILLISECONDS));
    return manager;
  }
}
