package concurrent.example.print;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替打印 A, B - 通过 LockSupport 实现<br>
 * LockSupport.park(thread)：指定线程从 runnable 变成 waitting<br>
 * LockSupport.unpark(thread): 指定线程从 waitting 变成 runnable<br>
 * LockSupport 基本原理<br>
 * 线程中有个计数器初始值为 0，调用 park 时，如果值为 0 则将线程挂起，如果值为 1 则将值修改为 0 然后什么都不做<br>
 * 调用 unpark 时，直接将值修改为 1
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class PrintByLockSupport {
  public static void main(String[] args) {
    Thread[] threads = new Thread[2];
    threads[0] =
        new Thread(
            () -> {
              for (int i = 0; i < 5; i++) {
                System.out.println("A");
                LockSupport.unpark(threads[1]);
                LockSupport.park();
              }
            });
    threads[1] =
        new Thread(
            () -> {
              for (int i = 0; i < 5; i++) {
                LockSupport.park();
                System.out.println("B");
                LockSupport.unpark(threads[0]);
              }
            });
    threads[0].start();
    threads[1].start();
  }
}
