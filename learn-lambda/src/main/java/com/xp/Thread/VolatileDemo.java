package com.xp.Thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/12/24.
 */
public class VolatileDemo
{
//	public static boolean flag = true;  // 线程不会结束，一直死循环
	public volatile static boolean flag = true; // 使用 volatile 关键字修饰之后，线程会结束

	public static void main(String[] args) throws InterruptedException
	{
		new Thread(() -> {
			while(flag){

			}
			System.out.println("线程结束");
		},"RunningThread").start();
		TimeUnit.SECONDS.sleep(10);
		flag = false;
	}
}
