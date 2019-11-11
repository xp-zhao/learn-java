package concurrent.future.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * FactorialSquareCalculator.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/11
 **/
public class FactorialSquareCalculator extends RecursiveTask<Integer> {

  private Integer n;

  public FactorialSquareCalculator(Integer n) {
    this.n = n;
  }

  @Override
  protected Integer compute() {
    if (n <= 1) {
      return n;
    }
    FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);

    calculator.fork();
    return n * n + calculator.join();
  }
}