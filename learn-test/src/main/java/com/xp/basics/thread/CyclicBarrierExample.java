package com.xp.basics.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class CyclicBarrierExample
{
	public static void main(String[] args)
	{
		final int totalThread = 10;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0; i < totalThread; i++){
			service.execute(() -> {
				System.out.print("before..");
				try
				{
					cyclicBarrier.await();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				catch (BrokenBarrierException e)
				{
					e.printStackTrace();
				} System.out.print("after..");
			});
		}
		service.shutdown();
	}
}
