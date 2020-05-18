package concurrent;

import java.util.concurrent.RecursiveTask;

/**
 * @author zhaoxiaoping
 * @Description: 求和计算
 * @Date 2020/5/18
 **/
public class SumCompute extends RecursiveTask<Long> {

  private Long start;
  private Long end;

  private Long temp = 1000L;

  public SumCompute(Long start, Long end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    if ((end - start) < temp) {
      Long sum = 0L;
      for (Long i = start; i <= end; i++) {
        sum += i;
      }
      return sum;
    } else {
      long middle = (start + end) / 2;
      SumCompute task1 = new SumCompute(start, middle);
      task1.fork();
      SumCompute task2 = new SumCompute(middle, end);
      task2.fork();
      return task1.join() + task2.join();
    }
  }
}
