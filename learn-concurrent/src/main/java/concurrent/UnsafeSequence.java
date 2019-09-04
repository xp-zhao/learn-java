package concurrent;

/**
 * UnsafeSequence.java 非线程安全的数值序列生成器
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/04
 **/
public class UnsafeSequence {

  private int value;

  public int getNext() {
    return value++;
  }

  public static void main(String[] args) {
    UnsafeSequence sequence = new UnsafeSequence();
    for (int i = 0; i < 10; i++) {
      System.out.println("main: " + sequence.getNext());
    }
    final UnsafeSequence sequence1 = new UnsafeSequence();
    new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        System.out.println("thread1: " + sequence1.getNext());
      }
    }, "thread1").start();

    new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        System.out.println("thread2: " + sequence1.getNext());
      }
    }, "thread2").start();
  }
}