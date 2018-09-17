package com.xp.basics.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class WaitNotifyExample
{
	public synchronized void before(){
		System.out.println("before");
		notifyAll();
	}

	public synchronized void after(){
		try
		{
			wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("after");
	}

	public static void main(String[] args)
	{
		ExecutorService service = Executors.newCachedThreadPool();
		WaitNotifyExample example = new WaitNotifyExample();
		service.execute(() -> example.after());
		service.execute(() -> example.before());
		service.shutdown();
	}
}
