package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-2
 **/
public class SafeWM {

  /**
   * 库存上限
   */
  private final AtomicLong upper = new AtomicLong(0);
  /**
   * 库存下限
   */
  private final AtomicLong lower = new AtomicLong(0);

  synchronized void setUpper(long v) {
    if (v < lower.get()) {
      throw new IllegalArgumentException();
    }
    upper.set(v);
  }

  synchronized void setLower(long v) {
    if (v > upper.get()) {
      throw new IllegalArgumentException();
    }
    lower.set(v);
  }

  public static void main(String[] args) {
    SafeWM safe = new SafeWM();
    safe.setLower(2);
    safe.setUpper(10);
    Thread A = new Thread(() -> safe.setLower(7));
    Thread B = new Thread(() -> safe.setUpper(5));
    A.start();
    B.start();
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(safe.lower.get());
    System.out.println(safe.upper.get());
  }
}
