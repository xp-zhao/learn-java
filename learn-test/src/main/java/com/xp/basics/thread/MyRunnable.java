package com.xp.basics.thread;

/**
 * Created by xp-zhao on 2018/9/13.
 */
public class MyRunnable implements Runnable
{
	@Override
	public void run()
	{
		Thread.yield();
	}
}
