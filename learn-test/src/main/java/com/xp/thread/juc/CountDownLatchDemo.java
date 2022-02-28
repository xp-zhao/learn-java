package com.xp.thread.juc;

import cn.hutool.core.util.StrUtil;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/** CountDownLatch 允许一个或者多个线程等待其他线程完成操作 */
public class CountDownLatchDemo {
  public static void main(String[] args) throws InterruptedException {
    //    test();
//    firstScene();
      secondScene();
  }

  private static void test() throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(2);
    new Thread(
            () -> {
              System.out.println(1);
              countDownLatch.countDown();
              System.out.println(2);
              countDownLatch.countDown();
            })
        .start();
    countDownLatch.await(); // 阻塞当前线程，直到 countDownLatch.countDown 减到 0
    System.out.println(3);
  }

  /** 场景一，让多个线程等待 */
  public static void firstScene() {
    CountDownLatch latch = new CountDownLatch(1);
    for (int i = 0; i < 5; i++) {
      new Thread(
              () -> {
                try {
                  // 所有线程都阻塞在这儿，等待计数器为 0
                  latch.await();
                  System.out.println(
                      StrUtil.format("[{}] 开始执行...", Thread.currentThread().getName()));
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              })
          .start();
    }
    // 等待 2s 后将计数器减一
    sleep(2000);
    latch.countDown();
  }

  /** 场景二，让单个线程等待 */
  public static void secondScene() throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(5);
    for (int i = 0; i < 5; i++) {
      new Thread(
              () -> {
                sleep(ThreadLocalRandom.current().nextInt(1000));
                System.out.println(Thread.currentThread().getName());
                latch.countDown();
              })
          .start();
    }
    // 主线程阻塞，等待计数器为 0
    latch.await();
    System.out.println("所有线程执行结束");
  }

  public static void sleep(long time) {
    try {
      TimeUnit.MILLISECONDS.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
