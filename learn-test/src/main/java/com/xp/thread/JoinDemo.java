package com.xp.thread;

/**
 * JoinDemo.java Join 测试
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/01
 **/
public class JoinDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new MyThread();
    t.start();
    t.join();
    System.out.println("主线程执行结束");
  }

  static class MyThread extends Thread {

    @Override
    public void run() {
      try {
        sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + ": 执行结束");
    }
  }
}