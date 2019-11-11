package concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/11
 **/
public class Client {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
//    calculate();
//    cancel();
    twoCalculate();
  }

  private static void calculate()
      throws InterruptedException, ExecutionException {
    SquareCalculator calculator = new SquareCalculator();
    Future<Integer> future = calculator.calculate(10);
    calculator.showdown();
    while (!future.isDone()) {
      System.out.println("Calculating...");
      TimeUnit.MILLISECONDS.sleep(300L);
    }
    Integer result = future.get();
    System.out.println("result: " + result);
  }

  private static void cancel() throws ExecutionException, InterruptedException {
    SquareCalculator calculator = new SquareCalculator();
    Future<Integer> future = calculator.calculate(4);
    calculator.showdown();
    System.out.println(future.cancel(true));
    future.get();
  }

  private static void twoCalculate() throws InterruptedException, ExecutionException {
    SquareCalculator calculator = new SquareCalculator();

    Future<Integer> future1 = calculator.calculate(10);
    Future<Integer> future2 = calculator.calculate(100);

    while (!(future1.isDone() && future2.isDone())) {
      System.out.println(
          String.format(
              "future1 is %s and future2 is %s",
              future1.isDone() ? "done" : "not done",
              future2.isDone() ? "done" : "not done"
          )
      );
      TimeUnit.MILLISECONDS.sleep(300L);
    }

    Integer result1 = future1.get();
    Integer result2 = future2.get();
    System.out.println(result1 + " and " + result2);
    calculator.showdown();
  }
}