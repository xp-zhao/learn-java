package interview.juc;

import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: volatile 示例 @Date 2021-10-14 */
public class VolatileExample {
  /** 不加 volatile 关键字时, ReadThread 不能读取到最新的值 */
  //  private static int flag = 0;
  /** 加上 volatile 关键字之后, ReadThread 就可以读到最新的值 */
  private static volatile int flag = 0;

  public static void main(String[] args) {
    new ReadThread().start();
    new WriteThread().start();
  }

  private static class ReadThread extends Thread {
    @Override
    public void run() {
      int localFlag = flag;
      while (true) {
        if (localFlag != flag) {
          System.out.println(Thread.currentThread().getName() + ": 读取到了修改后的标志位 " + flag);
          localFlag = flag;
        }
      }
    }
  }

  private static class WriteThread extends Thread {
    @Override
    public void run() {
      int localFlag = flag;
      while (true) {
        System.out.println(Thread.currentThread().getName() + ": 标志位被修改为了 " + ++localFlag);
        flag = localFlag;
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
