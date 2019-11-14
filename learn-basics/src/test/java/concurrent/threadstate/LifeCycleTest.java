package concurrent.threadstate;

import java.lang.Thread.State;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

/**
 * LifeCycleTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class LifeCycleTest {

  @Test
  public void testNewState() {
    Thread thread = new Thread(() -> System.out.println("thread"));
    Assert.assertEquals(thread.getState(), State.NEW);
  }

  @Test
  public void testRunnableState() {
    Thread thread = new Thread(() -> System.out.println("thread"));
    thread.start();
    Assert.assertEquals(thread.getState(), State.RUNNABLE);
  }

  @Test
  public void testBlockState() throws InterruptedException {
    Runnable r = () -> {
      synchronized (this) {
        while (true) {
        }
      }
    };
    Thread t1 = new Thread(r);
    Thread t2 = new Thread(r);
    t1.start();
    t2.start();
    TimeUnit.SECONDS.sleep(1);
    Assert.assertEquals(t2.getState(), State.BLOCKED);
  }

  @Test
  public void testWaitingState() throws InterruptedException {
    Runnable r = () -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };
    Thread thread = new Thread(r);
    thread.start();
    thread.join();
    System.out.println(Thread.currentThread().getState());
  }
}