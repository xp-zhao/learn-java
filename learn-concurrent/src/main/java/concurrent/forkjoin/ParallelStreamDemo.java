package concurrent.forkjoin;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.StopWatch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 并发测试
 *
 * @author zhaoxiaoping
 * @date 2022-9-20
 */
public class ParallelStreamDemo {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    parallelStream(list);
    forkJoin(list);
  }

  public static void parallelStream(List<Integer> list) {
    StopWatch watch = new StopWatch();
    watch.start();
    List<Boolean> res = new ArrayList<>();
    CollUtil.split(list, 2)
        .parallelStream()
        .forEach(
            item -> {
              System.out.println(item.stream().reduce(0, Integer::sum));
              res.add(true);
            });
    System.out.println(res);
    watch.stop();
    System.out.println("parallelStream 耗时: " + watch.getTotalTimeMillis());
  }

  public static void forkJoin(List<Integer> list) {
    StopWatch watch = new StopWatch();
    watch.start();
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    List<Boolean> res = forkJoinPool.invoke(new ForkJoinDemo(list));
    System.out.println(res);
    watch.stop();
    System.out.println("ForkJoin 耗时: " + watch.getTotalTimeMillis());
  }

  static class ForkJoinDemo extends RecursiveTask<List<Boolean>> {

    /** 每个任务最多打印的个数 */
    private static final int THRESHOLD = 2;

    private List<Integer> list;

    public ForkJoinDemo(List<Integer> list) {
      this.list = list;
    }

    @Override
    protected List<Boolean> compute() {

      if (list.size() <= THRESHOLD) {
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(list);
        System.out.println(sum + " " + Thread.currentThread().getName());
        return Arrays.asList(true);
      } else {
        int middle = (0 + list.size()) / 2;
        ForkJoinDemo left = new ForkJoinDemo(CollUtil.sub(list, 0, middle));
        ForkJoinDemo right = new ForkJoinDemo(CollUtil.sub(list, middle, list.size()));
        left.fork();
        right.fork();
        List<Boolean> list = new ArrayList<>();
        list.addAll(left.join());
        list.addAll(right.join());
        return list;
      }
    }
  }
}
