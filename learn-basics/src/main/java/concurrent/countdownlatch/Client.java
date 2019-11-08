package concurrent.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class Client {

  public static void main(String[] args) throws InterruptedException {
    List<String> list = new ArrayList<>();
    CountDownLatch countDownLatch = new CountDownLatch(5);
    List<Thread> workers = Stream.generate(() -> new Thread(new Worker(list, countDownLatch)))
        .limit(5)
        .collect(Collectors.toList());
    workers.forEach(Thread::start);
    countDownLatch.await();
    list.add("Latch released");
    System.out.println(list);
  }
}