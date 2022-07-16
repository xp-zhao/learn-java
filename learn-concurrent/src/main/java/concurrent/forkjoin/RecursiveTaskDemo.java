package concurrent.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 不带返回值的任务 (计算 0-100 的数字之和)
 *
 * @author xp-zhao
 * @date 2022/7/16
 */
public class RecursiveTaskDemo extends RecursiveTask<Integer> {

  /** 每个任务最多计算的个数 */
  private static final int THRESHOLD = 20;

  private int[] arr;
  private int start;
  private int end;

  public RecursiveTaskDemo(int[] arr, int start, int end) {
    this.arr = arr;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Integer compute() {
    int sum = 0;
    if ((end - start) <= THRESHOLD) {
      for (int i = start; i < end; i++) {
        sum += arr[i];
      }
      return sum;
    } else {
      System.err.println("=====任务分解======");
      // 将大任务分解成两个小任务
      int middle = (start + end) / 2;
      RecursiveTaskDemo left = new RecursiveTaskDemo(arr, start, middle);
      RecursiveTaskDemo right = new RecursiveTaskDemo(arr, middle, end);
      // 并行执行两个小任务
      left.fork();
      right.fork();
      // 把两个小任务累加的结果合并起来
      return left.join() + right.join();
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[100];
    // 初始化100个数字元素
    Arrays.fill(arr, 1);
    // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
    ForkJoinPool forkJoinPool = new ForkJoinPool();

    // 提交可分解的PrintTask任务
//        Future<Integer> future = forkJoinPool.submit(new RecursiveTaskDemo(arr, 0, arr.length));
//        System.out.println("计算出来的总和="+future.get());

    Integer integer = forkJoinPool.invoke( new RecursiveTaskDemo(arr, 0, arr.length)  );
    System.out.println("计算出来的总和=" + integer);

    // 关闭线程池
    forkJoinPool.shutdown();
  }
}
