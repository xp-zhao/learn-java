package com.xp.basics.thread.DeadLock;

import java.util.concurrent.TimeUnit;

/**
 * 展示可见性导致的死锁
 * Created by xp-zhao on 2018/10/9.
 */
public class VolatileDeadLock
{
	public static volatile boolean flag = false;

	static class AgeThread implements Runnable{
		@Override public void run()
		{
			System.out.println("AgeThread start");
			try
			{
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			flag = true;
			System.out.println("AgeThread end");
		}
	}

	static class GradeThread implements Runnable{
		@Override public void run()
		{
			System.out.println("GradeThread start");
			while(!flag){

			}
			System.out.println("GradeThread end");
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		AgeThread ageThread = new AgeThread();
		GradeThread gradeThread = new GradeThread();
		Thread t1 = new Thread(ageThread);
		Thread t2 = new Thread(gradeThread);
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println("结束");
	}
}
