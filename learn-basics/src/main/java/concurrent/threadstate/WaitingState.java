package concurrent.threadstate;

import java.util.concurrent.TimeUnit;

/**
 * WaitingState.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class WaitingState implements Runnable {

  public static Thread t1;

  public static void main(String[] args) {
    t1 = new Thread(new WaitingState());
    t1.start();
  }

  @Override
  public void run() {
    Thread t2 = new Thread(new SecondThread());
    t2.start();
    try {
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class SecondThread implements Runnable {

  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(WaitingState.t1.getState());
  }
}