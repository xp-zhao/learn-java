package concurrent.example;

import cn.hutool.core.date.StopWatch;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: ConcurrentHashMap 并发使用示例
 * @Date 2021-6-8
 **/
@Slf4j
public class ConcurrentHashMapExample {

  /**
   * 循环次数
   */
  private static int LOOP_COUNT = 10000000;
  /**
   * 线程数量
   */
  private static int THREAD_COUNT = 10;
  /**
   * 元素数量
   */
  private static int ITEM_COUNT = 1000;

  public static void main(String[] args) throws InterruptedException {
    ConcurrentHashMapExample example = new ConcurrentHashMapExample();
//    example.fillData();
    StopWatch stopWatch = new StopWatch();
    stopWatch.start("normalUse");
    Map<String, Long> normalUse = example.normalUse();
    stopWatch.stop();
    stopWatch.start("goodUse");
    Map<String, Long> goodUse = example.goodUse();
    stopWatch.stop();
    log.info(stopWatch.prettyPrint());
  }

  private void fillData() throws InterruptedException {
    int itemCount = 1000;
    ConcurrentHashMap<String, Long> initData = getData(itemCount - 100);
    // 初始化 900 个元素
    log.info("init size: {}", initData.size());
    int threadCount = 10;
    // 使用线程池并发处理填充逻辑
    ForkJoinPool forkJoinPool = new ForkJoinPool(threadCount);
    forkJoinPool.execute(() -> {
      IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
        // 加锁保证数据正确性
        synchronized (initData) {
          int gap = itemCount - initData.size();
          log.info("gap size: {}", gap);
          initData.putAll(getData(gap));
        }
      });
    });
    forkJoinPool.shutdown();
    forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
    log.info("finish size: {}", initData.size());
  }

  private ConcurrentHashMap<String, Long> getData(int count) {
    return LongStream.rangeClosed(1, count)
        .boxed()
        .collect(
            Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), i -> i, (o1, o2) -> o1,
                ConcurrentHashMap::new));
  }

  private Map<String, Long> normalUse() throws InterruptedException {
    ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>(
        ITEM_COUNT);
    ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
    forkJoinPool.execute(() -> {
      IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(i -> {
        //获得一个随机的Key
        String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
        synchronized (map) {
          if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
          } else {
            map.put(key, 1L);
          }
        }
      });
    });
    forkJoinPool.shutdown();
    forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
    return map;
  }

  private Map<String, Long> goodUse() throws InterruptedException {
    ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap<>(
        ITEM_COUNT);
    ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
    forkJoinPool.execute(() -> {
      IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(i -> {
        //获得一个随机的Key
        String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
        map.computeIfAbsent(key, k -> new LongAdder()).increment();
      });
    });
    forkJoinPool.shutdown();
    forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
    return map.entrySet().stream()
        .collect(Collectors.toMap(Entry::getKey, e -> e.getValue().longValue()));
  }
}
