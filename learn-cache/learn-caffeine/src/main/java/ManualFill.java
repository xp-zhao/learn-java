import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/** @Author: xp-zhao @Description: caffeine 手动填充示例 @DateTime: 2021/5/26 11:12 下午 */
public class ManualFill {
  public static void main(String[] args) {
    // 初始化缓存， 一分钟过期， 最大缓存数 100
    Cache<Integer, Integer> cache =
        Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).maximumSize(100).build();
    Integer key1 = 1;
    System.out.println(cache.getIfPresent(key1));
  }
}
