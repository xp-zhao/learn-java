import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: caffeine 使用示例 @Date 2021-10-14 */
public class CaffeineExample {
  public static void main(String[] args) {
    Cache<String, Optional<Integer>> cache =
        Caffeine.newBuilder()
            .initialCapacity(10)
            .maximumSize(100)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build();
    Cache<String, Integer> cache1 =
        Caffeine.newBuilder()
            .initialCapacity(10)
            .maximumSize(100)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build();
    System.out.println(cache.get("key", CaffeineExample::getValueForDb));
    System.out.println(cache.get("key", CaffeineExample::getValueForDb));
    System.out.println(cache1.get("key1", key -> getValueForDb(key).orElse(null)));
    System.out.println(cache1.get("key1", key -> getValueForDb(key).orElse(null)));
  }

  public static Optional<Integer> getValueForDb(String key) {
    System.out.println(key + " 缓存中未查询到数据, 从数据库中读取");
    return Optional.empty();
  }
}
