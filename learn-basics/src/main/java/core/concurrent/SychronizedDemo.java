package core.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import lombok.Data;

/**
 * SychronizedDemo.java Synchronized 关键字使用
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/18
 **/
public class SychronizedDemo {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(3);
    SynchronizedMethods summation = new SynchronizedMethods();

    IntStream.range(0, 1000).forEach(count -> service.submit(summation::calculate));
    service.awaitTermination(1000, TimeUnit.MILLISECONDS);
    service.shutdown();
    System.out.println(summation.getSum());
  }

  @Data
  static class SynchronizedMethods {

    private int sum = 0;

    public synchronized void calculate() {
      setSum(getSum() + 1);
    }
  }
}