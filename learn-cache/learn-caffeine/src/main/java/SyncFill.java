import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 同步填充示例
 * @Date 2021-5-27
 **/
public class SyncFill {

  public static void main(String[] args) {
    // 初始化缓存, 一分钟过期, 最大缓存数100
    LoadingCache<Integer, Integer> syncCache = Caffeine.newBuilder()
        .expireAfterWrite(1, TimeUnit.MINUTES)
        .maximumSize(100)
        .build(key -> {
          System.out.println("同步加载数据");
          return key;
        });

    Integer key = 1;
    // get: 从缓存中获取数据, 若缓存中没有则进行同步加载数据, 最终的值也会插入缓存
    System.out.println(syncCache.get(key));
    // getAll: 支持批量查找
    Map<Integer, Integer> map = syncCache.getAll(Arrays.asList(1, 2, 3));
    System.out.println(map);
  }
}
