package interview.thread.interrupt;

import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: 线程中断示例 @Date 2021-10-14 */
public class InterruptExample {
  public static void main(String[] args) throws InterruptedException {
//    Example1 example1 = new Example1();
//    example1.start();
//    TimeUnit.SECONDS.sleep(1);
//    example1.interrupt();
    Example2 example2 = new Example2();
    example2.start();
    TimeUnit.SECONDS.sleep(1);
    example2.setShouldRun(false);
    example2.interrupt();
  }

  private static class Example1 extends Thread {
    @Override
    public void run() {
      while (!isInterrupted()) {
        System.out.println("线程运行中...");
      }
    }
  }

  private static class Example2 extends Thread {
    private Boolean shouldRun = true;

    @Override
    public void run() {
      while (shouldRun) {
        try {
          System.out.println("线程运行中...");
          TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    
    public void setShouldRun(Boolean shouldRun) {
      this.shouldRun = shouldRun;
    }
  }
}
