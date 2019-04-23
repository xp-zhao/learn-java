package com.xp.thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）,主要作用：让一组线程到达一个屏障时被阻塞，直到最后一个
 * 线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续执行。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,() -> {
            // 线程达到屏障时，优先执行的线程
            System.out.println(3);
        });
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        }).start();
        cyclicBarrier.await();
        System.out.println(2);
    }
}
