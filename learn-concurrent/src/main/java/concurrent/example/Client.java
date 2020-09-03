package concurrent.example;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-3
 **/
public class Client {

  public static void main(String[] args) throws InterruptedException {
    // 异步操作
    LocalTime start = LocalTime.now();
    Order order = new Order();
    Thread t1 = new Thread(() -> {
      order.getPOrder();
      order.setPos(3);
    });
    t1.start();
    Thread t2 = new Thread(() -> {
      order.getDOrder();
      order.setDos(3);
    });
    t2.start();
    // 等待 t1、t2 结束
    t1.join();
    t2.join();
    System.out.println(order.getDos());
    order.check();
    order.save();
    LocalTime end = LocalTime.now();
    System.out.println(ChronoUnit.SECONDS.between(start, end));
  }
}
