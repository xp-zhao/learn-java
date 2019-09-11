package com.xp.thread.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadPoolExcecutorDemo.java 线程池使用示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/11
 **/
public class ThreadPoolExcecutorDemo {

  public static void main(String[] args) {
    // 设置缓存队列长度为 4
    BlockingQueue queue = new LinkedBlockingQueue(4);
    UserThreadFactory factory = new UserThreadFactory("测试线程");
    // 拒绝策略
    UserRejectHandler handler = new UserRejectHandler();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 60,
        TimeUnit.SECONDS, queue, factory, handler);
    for (int i = 1; i <= 10; i++) {
      executor.execute(new Task(i));
    }
    executor.shutdown();
  }

  private static class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    UserThreadFactory(String group) {
      namePrefix = "UserThreadFactory's " + group + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
      String name = namePrefix + nextId.getAndIncrement();
      Thread thread = new Thread(null, task, name, 0);
      System.out.println(thread.getName());
      return thread;
    }
  }

  private static class Task implements Runnable {

    private int num;

    public Task(int num){
      this.num = num;
    }

    @Override
    public void run() {
      System.out.println("running_" + num);
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private static class UserRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
      System.out.println("task rejected. " + executor.toString());
    }
  }
}