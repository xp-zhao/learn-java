package concurrent.waitandsleep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ThreadA.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class ThreadA extends Thread {

  private static final Logger LOG = LoggerFactory.getLogger(ThreadA.class);

  private static final ThreadB b = new ThreadB();

  public static void main(String[] args) throws InterruptedException {
    b.start();
    synchronized (b) {
      while (b.sum == 0) {
        LOG.debug("Waiting for ThreadB to complete...");
        b.wait();
      }
      LOG.debug("ThreadB has completed. Sum from that thread is: " + b.sum);
    }
  }
}