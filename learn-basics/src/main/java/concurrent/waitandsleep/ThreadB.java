package concurrent.waitandsleep;

/**
 * ThreadB.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class ThreadB extends Thread {

  int sum;

  @Override
  public void run() {
    synchronized (this) {
      int i = 0;
      while (i < 10000) {
        sum += i;
        i++;
      }
      notify();
    }
  }
}