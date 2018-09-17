package com.xp.basics.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class AwaitSignalExample
{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void before(){
		lock.lock();
		try
		{
			System.out.println("before");
			condition.signalAll();
		}finally
		{
			lock.unlock();
		}
	}

	public void after(){
		lock.lock();
		try
		{
			condition.await();
			System.out.println("after");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}

	public static void main(String[] args)
	{
		ExecutorService service = Executors.newCachedThreadPool();
		AwaitSignalExample example = new AwaitSignalExample();
		service.execute(() -> example.after());
		service.execute(() -> example.before());
		service.shutdown();
	}
}
