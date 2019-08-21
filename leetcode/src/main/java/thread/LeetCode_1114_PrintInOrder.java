package thread;

import java.util.concurrent.CountDownLatch;

/**
 * LeetCode_1114_PrintInOrder.java 按顺序打印
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/21
 **/
public class LeetCode_1114_PrintInOrder {

  public static void main(String[] args) {
    Foo foo = new Foo();
    Thread one = new Thread(() -> System.out.print("one"), "A");
    Thread two = new Thread(() -> System.out.print("two"), "B");
    Thread three = new Thread(() -> System.out.print("three"), "C");
    new Thread(() -> foo.one(one)).start();
    new Thread(() -> {
      try {
        foo.two(two);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
    new Thread(() -> {
      try {
        foo.three(three);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
  }

  static class Foo {

    /**
     * 使用 CountDownLatch 保证多线程调用 one、two、three 方法时，始终打印 onttwothree
     */
    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    Foo() {

    }

    public void one(Runnable one) {
      one.run();
      second.countDown();
    }

    public void two(Runnable two) throws InterruptedException {
      second.await();
      two.run();
      third.countDown();
    }

    public void three(Runnable three) throws InterruptedException {
      third.await();
      three.run();
    }
  }
}