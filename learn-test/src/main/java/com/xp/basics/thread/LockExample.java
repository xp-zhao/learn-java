package com.xp.basics.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class LockExample
{
	private Lock lock = new ReentrantLock();
	public void func(){
		lock.lock();
		try
		{
			for(int i = 0; i < 10; i++){
				System.out.print(i +" ");
				TimeUnit.SECONDS.sleep(1);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock(); // 释放锁
		}
	}
}
