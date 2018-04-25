package com.xp.thread;

/**
 * Created by xp-zhao on 2018/4/25.
 */
public class print2 implements Runnable
{
	private int num;
	private Object lock;

	public print2(int num,Object lock)
	{
		this.num = num;
		this.lock = lock;
	}

	@Override
	public void run()
	{
		for(char a='a'; a <= 'z'; a++)
		{
			synchronized (lock)
			{
				if(num == 0)
				{
					num = 1;
					System.out.print(a);
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
