package com.xp.basics.thread.DeadLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xp-zhao on 2019/4/17.
 */
class MyData{
	volatile int num = 0;
	public void add(){
		this.num = 60;
	}

	public void addPlusPlus(){
		this.num++;
	}

	AtomicInteger atomicInteger = new AtomicInteger();
	public void addAtomic(){
		atomicInteger.getAndIncrement();
	}
}
public class VolatileDemo
{
	public static void main(String[] args) {
		MyData data = new MyData();
		for(int i = 1; i <= 20; i++)
		{
			new Thread(() -> {
				for(int i1 = 1; i1 <= 1000; i1++) {
					data.addPlusPlus();
					data.addAtomic();
				}
			},String.valueOf(i)).start();
		}
		while(Thread.activeCount() > 2){
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName() + " int type, finally num value: " + data.num);
		System.out.println(Thread.currentThread().getName() + " AtomicInteger, finally num value: " + data.atomicInteger);
//		new Thread(() -> {
//			System.out.println(Thread.currentThread().getName() + " come in");
//			try
//			{
//				TimeUnit.SECONDS.sleep(3);
//			}
//			catch (InterruptedException e)
//			{
//				e.printStackTrace();
//			}
//			data.add();
//			System.out.println(Thread.currentThread().getName() + " updated num value: "+data.num);
//		},"aaa").start();
//
//		while(data.num == 0){
//
//		}
//		System.out.println(Thread.currentThread().getName() + " mission is over");
	}

}
