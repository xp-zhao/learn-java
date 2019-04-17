package com.xp.basics.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA 问题的解决 AtomicStampedReference
 * Created by xp-zhao on 2019/4/17.
 */
public class ABADemo
{
	static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
	static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100 , 1);

	public static void main(String[] args) {
		new Thread(() -> {
			atomicReference.compareAndSet(100 , 101);
			atomicReference.compareAndSet(101 , 100);
		},"t1").start();

		new Thread(() ->{
			sleep(1);
			System.out.println(atomicReference.compareAndSet(100 , 2019)+"\t"+atomicReference.get());
		},"t2").start();
		sleep(2);
		System.out.println("*************ABA问题的解决*************");
		new Thread(() -> {
			int stamp = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+stamp);
			sleep(1);
			atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
			System.out.println(Thread.currentThread().getName()+"\t第二次版本号："+atomicStampedReference.getStamp());
			atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
			System.out.println(Thread.currentThread().getName()+"\t第三次版本号："+atomicStampedReference.getStamp());
		},"t3").start();
		new Thread(() -> {
			int stamp = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+stamp);
			sleep(3);
			boolean result = atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1);
			System.out.println(Thread.currentThread().getName()+"\t是否修改成功："+result+"\t当前最新实际版本号："+atomicStampedReference.getStamp());
			System.out.println(Thread.currentThread().getName()+"\t当前最新值："+atomicStampedReference.getReference());

		},"t4").start();
	}

	public static void sleep(long time){
		try
		{
			TimeUnit.SECONDS.sleep(time);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
