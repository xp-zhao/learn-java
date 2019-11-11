package concurrent.future.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/11
 **/
public class Client {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    FactorialSquareCalculator calculator = new FactorialSquareCalculator(5);
    forkJoinPool.execute(calculator);
    System.out.println(calculator.get());
  }
}