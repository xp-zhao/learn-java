package com.xp.basics.thread;

/**
 * ThreadLocal 使用示例
 * Created by xp-zhao on 2019/3/21.
 */
public class ThreadLocalDemo
{
	private static String str;
	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

	public static void main(String[] args) throws InterruptedException
	{
		str = "main";
		threadLocal.set("main");
		Thread thread = new Thread(() -> {
			str = "child";
			threadLocal.set("child");
		},"threadlocal");
		thread.start();
		thread.join();
		System.out.println("str: " + str);
		System.out.println("threadlocal: " + threadLocal.get());
	}
}
