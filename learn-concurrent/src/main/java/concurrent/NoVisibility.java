package concurrent;

/**
 * NoVisibility.java 没有同步的共享变量
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/04
 **/
public class NoVisibility {

  private static boolean ready;
  private static int number;

  public static void main(String[] args) {
    new Thread(() -> {
      while (!ready){
        Thread.yield();
      }
      System.out.println(number);
    }).start();

    number = 42;
    ready = true;
  }
}