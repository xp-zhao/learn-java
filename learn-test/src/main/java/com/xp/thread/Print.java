package com.xp.thread;

/**
 * 两个线程交替打印数字和字母
 * Created by xp-zhao on 2018/4/25.
 */
public class Print
{
	private static int num = 1;
	private static Object lock = new Object();

	public static void main(String[] args)
	{
		final int x = 1;
		final Example example = new Example();
		example.x = 2;
		example.x = 3;
		Thread t1 = new Thread(new print1(num,lock));
		Thread t2 = new Thread(new print2(num,lock));
		t1.start();
		t2.start();
	}

	public static class Example{
		private int x = 0;
	}
}
