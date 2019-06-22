package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;

/**
 * @description: guava cache测试
 * @author: zhaoxiaoping
 * @create: 2019/06/22
 **/
public class GuavaCacheDemo {

  public static void main(String[] args) {
    Cache<String, String> cacheMap = CacheBuilder.newBuilder()
        .expireAfterAccess(30L, TimeUnit.SECONDS)
        .expireAfterWrite(10L, TimeUnit.MINUTES)
        .concurrencyLevel(6)
        .initialCapacity(100)
        .maximumSize(1000)
        .softValues()
        .build();

    cacheMap.put("name", "张三");
    System.out.println(cacheMap.getIfPresent("name"));
  }
}