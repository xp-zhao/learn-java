package concurrent.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author zhaoxiaoping
 * @Description: 大数组求和测试
 * @Date 2020-10-22
 **/
public class SumTask extends RecursiveTask<Long> {

  static final int THRESHOLD = 100;
  long[] array;
  int start;
  int end;

  SumTask(long[] array, int start, int end) {
    this.array = array;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    if (end - start <= THRESHOLD) {
      // 任务足够小，直接计算
      long sum = 0;
      for (int i = start; i < end; i++) {
        sum += array[i];
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      System.out.println(String.format("compute %d~%d = %d", start, end, sum));
      return sum;
    }
    // 任务太大，一分为二
    int middle = (end + start) / 2;
    System.out.println(
        String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
    SumTask sumTask1 = new SumTask(array, start, middle);
    SumTask sumTask2 = new SumTask(array, middle, end);
    invokeAll(sumTask1, sumTask2);
    Long result1 = sumTask1.join();
    Long result2 = sumTask2.join();
    Long result = result1 + result2;
    System.out.println("result = " + result1 + " + " + result2 + " ==> " + result);
    return result;
  }

  public static void main(String[] args) {
    // 创建随机数组成的数组:
    long[] array = new long[400];
    Arrays.fill(array, 1);
    // fork/join task:
    ForkJoinPool fjp = new ForkJoinPool();
    ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
    long startTime = System.currentTimeMillis();
    Long result = fjp.invoke(task);
    long endTime = System.currentTimeMillis();
    System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
  }
}
