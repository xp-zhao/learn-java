package com.xp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xp-zhao on 2019/3/8.
 */
public class ThreadPool
{
	public static void main(String[] args) {
		ExecutorService cacheExecutor = Executors.newCachedThreadPool();
		ExecutorService fixExecutor = Executors.newFixedThreadPool(1);
		ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
		ExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
	}
}
