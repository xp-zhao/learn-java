import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xp-zhao @Description: caffeine 手动填充示例 @DateTime: 2021/5/26 11:12 下午
 */
public class ManualFill {

  public static void main(String[] args) {
    // 初始化缓存， 一分钟过期， 最大缓存数 100
    Cache<Integer, Integer> cache =
        Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).maximumSize(100).build();
    Integer key1 = 1;
    // getIfPresent :如果缓存中不存在,则返回 null
    System.out.println(cache.getIfPresent(key1));
    // get: 如果 key 在缓存中不存在, 则执行 Function 函数, 并将结果插入缓存
    System.out.println(cache.get(key1, k -> 2));
    System.out.println(cache.getIfPresent(key1));
    int value1 = 3;
    cache.put(key1, value1);
    System.out.println(cache.getIfPresent(key1));
    
    // 移除数据, 使数据失效
    cache.invalidate(key1);
  }
}
