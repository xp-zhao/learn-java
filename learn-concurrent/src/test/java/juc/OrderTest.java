package juc;

import concurrent.example.Order;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-3
 **/
public class OrderTest {

  @Test
  public void testSerial() {
    // 串行操作
    LocalTime start = LocalTime.now();
    Order order = new Order();
    order.getPOrder();
    order.getDOrder();
    order.check();
    order.save();
    LocalTime end = LocalTime.now();
    System.out.println(ChronoUnit.SECONDS.between(start, end));
  }

  @Test
  public void testAsync() throws InterruptedException {
    // 异步操作
    LocalTime start = LocalTime.now();
    Order order = new Order();
    Thread t1 = new Thread(() -> order.getPOrder());
    t1.start();
    Thread t2 = new Thread(() -> order.getDOrder());
    t2.start();
    // 等待 t1、t2 结束
    t1.join();
    t2.join();
    System.out.println("test");
    order.check();
    order.save();
    LocalTime end = LocalTime.now();
    System.out.println(ChronoUnit.SECONDS.between(start, end));
  }

  @Test
  public void testThreadPool() throws InterruptedException {
    // 线程池异步操作
    LocalTime start = LocalTime.now();
    Order order = new Order();
    // 计数器
    CountDownLatch latch = new CountDownLatch(2);
    Executor executor = Executors.newFixedThreadPool(2);
    executor.execute(() -> {
      order.getPOrder();
      latch.countDown();
    });
    executor.execute(() -> {
      order.getDOrder();
      latch.countDown();
    });

    // 等待两个查询操作结束
    latch.await();
    System.out.println("test");
    order.check();
    order.save();
    LocalTime end = LocalTime.now();
    System.out.println(ChronoUnit.SECONDS.between(start, end));
  }
}
