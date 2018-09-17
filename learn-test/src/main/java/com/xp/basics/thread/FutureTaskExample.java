package com.xp.basics.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class FutureTaskExample
{
	public static void main(String[] args) throws ExecutionException, InterruptedException
	{
		FutureTask<Integer> task = new FutureTask<>(() -> {
			int result = 10;
			for(int i = 0; i < 100; i++){
				TimeUnit.MILLISECONDS.sleep(10);
				result += i;
			}
			return result;
		});

		Thread computeThread = new Thread(task);
		computeThread.start();

		Thread otherThread = new Thread(() -> {
			System.out.println("other task is running...");
			try
			{
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		});
		otherThread.start();
		System.out.println(task.get());
	}
}
