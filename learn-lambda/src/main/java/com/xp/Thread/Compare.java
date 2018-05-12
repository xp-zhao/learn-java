package com.xp.Thread;

/**
 * Created by xp-zhao on 2018/5/10.
 */
public class Compare
{
	public static void main(String[] args)
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				System.out.println("Before Java8, too much code for too little to do");
			}
		}).start();

		new Thread(()-> System.out.println("In Java8, Lambda expression rocks !!")).start();
	}
}
