package com.xp.thread.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore（信号量）：用来控制同时访问特定资源的线程数量，通过
 * 协调各个线程，以保证合理的使用公共资源
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        final int THREAD_NUM = 30;
        ExecutorService service = Executors.newFixedThreadPool(THREAD_NUM);
        Semaphore semaphore = new Semaphore(10); // 只允许 10 个线程并发执行
        for (int i = 0; i < THREAD_NUM; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire(); // 获取执行许可证
                    System.out.println("play");
                    semaphore.release(); // 归还许可证
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }
}
