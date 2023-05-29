package core;

/**
 * @author zhaoxiaoping
 * @date 2023-5-24
 */
public class ThreadExample {

  public static final Object lock = new Object();
  public boolean stop = false;

  public static void main(String[] args) throws InterruptedException {
    new Thread().start();
    for (int i = 1; i <= 4; i++) {
      for (int i1 = 0; i1 < i; i1++) {
        //
      }
    }
  }

  public class B {
    public void test() {
      System.out.println(stop);
    }
  }
}

class A {
  public void test() {
    System.out.println(ThreadExample.lock);
  }
}
