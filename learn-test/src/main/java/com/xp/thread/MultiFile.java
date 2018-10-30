package com.xp.thread;

import com.xp.utils.DateUtil;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/9/6.
 */
public class MultiFile
{
	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 10; i++){
			service.submit(new CreateFile());
			TimeUnit.SECONDS.sleep(1);
		}
		service.shutdown();
	}

	public static class CreateFile implements Runnable{
		@Override
		public void run()
		{
			String dayStr = DateUtil.formatShortDateTime(new Date());
			String filename = "playListInfo_" + dayStr + ".txt";
			System.out.println(filename);
		}
	}
}
