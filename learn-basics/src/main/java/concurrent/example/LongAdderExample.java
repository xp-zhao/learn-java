package concurrent.example;

import cn.hutool.core.util.StrUtil;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhaoxiaoping
 * @Description: 累加器示例
 * @Date 2021-6-9
 **/
public class LongAdderExample {

  private long i = 0;
  private LongAdder j = new LongAdder();

  public static void main(String[] args) throws InterruptedException {
    ForkJoinPool forkJoinPool = new ForkJoinPool(10);
    LongAdderExample example = new LongAdderExample();
    for (int i = 0; i < 10000; i++) {
      forkJoinPool.execute(() -> {
        example.normalAdd();
        example.goodAdd();
      });
    }
    forkJoinPool.shutdown();
    forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
    System.out.println(StrUtil.format("普通自增结果: {}", example.i));
    System.out.println(StrUtil.format("LongAdder 自增结果: {}", example.j.intValue()));
  }

  public void normalAdd() {
    i++;
  }

  public void goodAdd() {
    j.increment();
  }
}
