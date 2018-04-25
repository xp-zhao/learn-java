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
		Thread t1 = new Thread(new print1(num,lock));
		Thread t2 = new Thread(new print2(num,lock));
		t1.start();
		t2.start();
	}
}
