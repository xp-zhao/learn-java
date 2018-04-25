package com.xp.thread;

/**
 * Created by xp-zhao on 2018/4/25.
 */
public class print1 implements Runnable
{
	private int num;
	private Object lock;

	public print1(int num,Object lock)
	{
		this.num = num;
		this.lock = lock;
	}

	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			synchronized (lock)
			{
				if(num == 1)
				{
					num = 0;
					System.out.print(i);
					lock.notify();
					try
					{
						lock.wait();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
}
