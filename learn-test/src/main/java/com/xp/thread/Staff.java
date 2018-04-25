package com.xp.thread;

/**
 * Created by xp-zhao on 2018/4/25.
 */
public class Staff
{
	private static Object lock = new Object();
	private static int num = 1;
	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread()
		{
			@Override
			public void run()
			{
				for(int i = 0; i < 26; i++)
				{
					synchronized (lock)
					{
						if(num == 1)
						{
							num = 0;
							System.out.print(i % 10);
							lock.notifyAll();
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		};
		Thread t2 = new Thread()
		{
			@Override
			public void run()
			{
				for(char a = 'a'; a <= 'z'; a++)
				{
					synchronized (lock)
					{
						if(num == 0)
						{
							num = 1;
							System.out.print(a);
							lock.notifyAll();
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}
				}
			}
		};
		t1.start();
		t2.start();
	}
}
