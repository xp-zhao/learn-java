import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 异步填充示例
 * @Date 2021-5-27
 **/
public class AsyncFill {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    AsyncCache<Integer, Integer> asyncCache = Caffeine.newBuilder()
        .expireAfterWrite(1, TimeUnit.MINUTES).maximumSize(100)
        .executor(Executors.newSingleThreadExecutor()).buildAsync();

    Integer key = 1;
    CompletableFuture<Integer> future = asyncCache.get(key, k -> {
      System.out.println("当前所在线程：" + Thread.currentThread().getName());
      return getInDb(k);
    });
    int value = future.get();
    System.out.println("当前所在线程：" + Thread.currentThread().getName());
    System.out.println(value);
  }

  public static Integer getInDb(Integer key) {
    return key + 1;
  }
}
