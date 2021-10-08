package interview.aqs;

import java.util.UUID;

/** @author zhaoxiaoping @Description: @Date 2021-10-8 */
public class Example {
  private static long count = 0;
  private static MyLock lock = new MyLock();

  public static void main(String[] args) throws InterruptedException {
    
    System.out.println(UUID.randomUUID().toString());
    Thread t1 = new Thread(() -> add());
    Thread t2 = new Thread(() -> add());
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(count);
  }

  public static void add() {
    lock.lock();
    for (int i = 0; i < 10000; i++) {
      count++;
    }
    lock.unlock();
  }
}
