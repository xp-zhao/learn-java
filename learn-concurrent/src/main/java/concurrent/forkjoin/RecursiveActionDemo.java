package concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 不带返回值的任务 (打印 0-100 的数字)
 *
 * @author xp-zhao
 * @date 2022/7/16
 */
public class RecursiveActionDemo extends RecursiveAction {

  /** 每个任务最多打印的个数 */
  private static final int THRESHOLD = 20;

  private int start;
  private int end;

  public RecursiveActionDemo(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected void compute() {
    if ((end - start) <= THRESHOLD) {
      for (int i = start; i < end; i++) {
        System.out.println(Thread.currentThread().getName() + " i的值: " + i);
      }
    }else{
      // 将大任务分解成小任务
      int middle = (start + end) / 2;
      RecursiveActionDemo left = new RecursiveActionDemo(start, middle);
      RecursiveActionDemo right = new RecursiveActionDemo(middle, end);
      left.fork();
      right.fork();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    // 提交可分解的PrintTask任务
    forkJoinPool.submit(new RecursiveActionDemo(0, 100));
    //阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束
    forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
    // 关闭线程池
    forkJoinPool.shutdown();
  }
}
