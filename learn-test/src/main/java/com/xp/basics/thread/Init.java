package com.xp.basics.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xp-zhao on 2018/9/13.
 */
public class Init
{
	public static void main(String[] args)
	{
		LockExample example = new LockExample();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(() -> example.func());
		service.execute(() -> example.func());
		service.shutdown();
	}
}
