package concurrent.waitandsleep;

/**
 * WaitAndSleep.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class WaitAndSleep {

  private static Object LOCK = new Object();

  public static void main(String[] args) throws InterruptedException {
    sleepWait();
  }

  private static void sleepWait() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println(
        "Thread '" + Thread.currentThread().getName() + "' is woken after sleeping for 1 second");
    synchronized (LOCK) {
      LOCK.wait(1000);
      System.out.println("Object '" + LOCK + "' is woken after" + " waiting for 1 second");
    }
  }
}