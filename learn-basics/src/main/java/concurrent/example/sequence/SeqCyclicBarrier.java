package concurrent.example.sequence;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 让 T1, T2, T3 三个线程顺序执行-通过 CyclicBarrier 实现
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class SeqCyclicBarrier {
  public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
    CyclicBarrier barrier = new CyclicBarrier(1);
    Thread t1 =
        new Thread(
            () -> System.out.println(Thread.currentThread().getName() + " is Running"), "T1");
    t1.start();
    barrier.await();
    Thread t2 =
        new Thread(
            () -> System.out.println(Thread.currentThread().getName() + " is Running"), "T2");
    t2.start();
    barrier.await();
    Thread t3 =
        new Thread(
            () -> System.out.println(Thread.currentThread().getName() + " is Running"), "T3");
    t3.start();
    barrier.await();
  }
}
