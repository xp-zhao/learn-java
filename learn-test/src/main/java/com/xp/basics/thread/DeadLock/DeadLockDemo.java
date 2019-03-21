package com.xp.basics.thread.DeadLock;

import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/10/9.
 */
public class DeadLockDemo
{
	private static String A = "A";
	private static String B = "B";

	public static void main(String[] args)
	{
		new DeadLockDemo().deadLock();
	}

	private void deadLock(){
		Thread t1 = new Thread(() -> {
			synchronized (A){
				try
				{
					TimeUnit.MILLISECONDS.sleep(2);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (B){
					System.out.println("1");
				}
			}
		});
		Thread t2 = new Thread(() -> {
			synchronized (B){
				synchronized (A){
					System.out.println(2);
				}
			}
		});
		t1.start();
		t2.start();
	}
}
