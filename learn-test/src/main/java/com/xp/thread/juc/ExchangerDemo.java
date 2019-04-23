package com.xp.thread.juc;

import java.util.concurrent.Exchanger;

/**
 * Exchange(交换者)：是一个用于线程间协作的工具类。Exchanger 用于线程间的数据交换。
 * 两个线程通过 exchange 交换数据，如果一个线程先执行 exchange 方法，他会一直瞪大
 * 第二个线程也执行 exchange 方法，当两个线程都到达时，这两个线程就可以交换数据，将
 * 本线程产生的数据传递个另一个线程。
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                String a = "a 数据";
                String b = exchanger.exchange(a);
                System.out.println("在 A 中获取到的 B 的数据是："+b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();
        new Thread(() -> {
            try {
                String b = "b 数据";
                String a = exchanger.exchange(b);
                System.out.println("在 B 中获取到的 A 的数据是："+a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();
    }
}
