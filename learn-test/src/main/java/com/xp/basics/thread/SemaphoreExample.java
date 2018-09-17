package com.xp.basics.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class SemaphoreExample
{
	public static void main(String[] args)
	{
		final int clientCount = 3;
		final int totalCount = 10;
		Semaphore semaphore = new Semaphore(clientCount);
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++){
			service.execute(() -> {
				try
				{
					semaphore.acquire();
					System.out.print(semaphore.availablePermits()+ " " );
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					semaphore.release();
				}
			});
		}
		service.shutdown();
	}
}
