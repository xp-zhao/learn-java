package com.xp.basics.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class ThreadUnsafeExample
{
	private int count = 0;
	public synchronized void add(){
		count++;
	}
	public int get(){
		return count;
	}

	public static void main(String[] args) throws InterruptedException
	{
		final int threadSize = 1000;
		ThreadUnsafeExample example = new ThreadUnsafeExample();
		final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0; i < threadSize; i++){
			service.execute(() -> {
				example.add();
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		service.shutdown();
		System.out.println(example.get());
	}
}
