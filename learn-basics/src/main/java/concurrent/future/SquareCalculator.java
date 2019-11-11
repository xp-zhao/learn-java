package concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * SquareCalculator.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/11
 **/
public class SquareCalculator {

//  private ExecutorService service = Executors.newSingleThreadExecutor();
  private ExecutorService service = Executors.newFixedThreadPool(2);

  public Future<Integer> calculate(Integer input) {
    System.out.println("calculating square for: " + input);
    return service.submit(() -> {
      TimeUnit.SECONDS.sleep(1L);
      return input * input;
    });
  }

  public void showdown(){
    service.shutdown();
  }
}