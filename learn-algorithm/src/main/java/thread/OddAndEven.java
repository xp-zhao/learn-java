package thread;

/**
 * 两个线程交替打印奇偶数 Created by xp-zhao on 2019/3/12.
 */
public class OddAndEven {

  public static boolean flag = true;

  public static void main(String[] args) {
    Data data = new Data();
    new Thread(() -> data.printOdd(), "odd").start();
    new Thread(() -> data.printEven(), "even").start();
  }

  private static void back() {
    Object lock = new Object();
    new Thread(() -> {
      int i = 2;
      while (i <= 100) {
        synchronized (lock) {
          if (!flag) {
            System.out.print(i + " ");
            flag = true;
            i += 2;
            lock.notify();
          } else {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }, "odd").start();
    new Thread(() -> {
      int i = 1;
      while (i <= 100) {
        synchronized (lock) {
          if (flag) {
            System.out.print(i + " ");
            flag = false;
            i += 2;
            lock.notify();
          } else {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }, "even").start();
  }

  static class Data {

    private int i = 0;

    public void printOdd() {
      if (i % 2 != 0) {
        System.out.println(Thread.currentThread().getName() + ":" + i);
      }
      i++;
    }

    public void printEven() {
      if (i % 2 == 0) {
        System.out.println(Thread.currentThread().getName() + ":" + i);
      }
      i++;
    }
  }
}
