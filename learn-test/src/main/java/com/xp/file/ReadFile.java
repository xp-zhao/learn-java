package com.xp.file;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xp-zhao on 2018/11/1.
 */
public class ReadFile implements Runnable
{

	private BlockingQueue<List<String>> queue;
	public volatile boolean isEnd = false;

	public ReadFile(BlockingQueue<List<String>> queue)
	{
		this.queue = queue;
	}

	@Override
	public void run()
	{
		try
		{
			File file = new File("D:/file/test/666.txt");
			long start = System.currentTimeMillis();
			String line;
			int i = 0;
//			LineIterator it = org.apache.commons.io.FileUtils.lineIterator(file, "UTF-8");
			BufferedReader reader = null;
			FileInputStream fis = null;
			fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			reader = new BufferedReader(new InputStreamReader(bis,"UTF-8"), 10 * 1024 * 1024);//10M缓存
			System.out.println("读文件线程，使用内存="+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) / 1024 / 1024+"M");
			List<String> list = new ArrayList<>(500);
//			while(it.hasNext())
			while((line = reader.readLine()) != null)
			{
				i++;
//				line = it.nextLine();
				list.add(line.split("d")[1]);
				if(CollectionUtils.isNotEmpty(list) && list.size() % 500 == 0)
				{
					queue.put(list);
					list = new ArrayList<>(500);
				}
			}
			if(CollectionUtils.isNotEmpty(list))
			{
				queue.put(list);
			}
			long end = System.currentTimeMillis();
			System.out.println("读文件线程结束："+i);
			long result = end - start;
			System.out.println("读文件耗时（毫秒）："+ result);
			System.out.println("读文件线程，使用内存="+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()) / 1024 / 1024+"M,使用时间毫秒="+(end-start));
			isEnd = true;
		}
		catch (Exception e)
		{

		}
	}
}
