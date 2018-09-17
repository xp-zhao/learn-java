package com.xp.basics.thread;

import java.util.concurrent.Callable;

/**
 * Created by xp-zhao on 2018/9/13.
 */
public class MyCallable implements Callable<Integer>
{
	@Override
	public Integer call() throws Exception
	{
		return 666;
	}
}
