package com.xp.file;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/11/1.
 */
public class WriteFile implements Runnable
{
	private BlockingQueue<List<String>> queue;
	private ReadFile readFile;

	public WriteFile(BlockingQueue<List<String>> queue,ReadFile readFile)
	{
		this.queue = queue;
		this.readFile = readFile;
	}

	@Override public void run()
	{
		List<String> list = null;
		File file = new File("D:/file/test/result.txt");
		BufferedWriter writer = null;
		long success = 0;
		long failed = 0;
		try
		{
			writer = new BufferedWriter(new FileWriter(file, true));
		}
		catch (IOException e)
		{
			System.out.println("创建文件失败");
			return;
		}
		long startDate = System.currentTimeMillis();
		while(CollectionUtils.isNotEmpty(queue) || !readFile.isEnd)
		{
			try
			{
				list = queue.poll(5 , TimeUnit.SECONDS);
				if(CollectionUtils.isNotEmpty(list))
				{
					//一行一行的写入文件
					for(String data : list)
					{
						writer.write(data);
						writer.newLine();
					}
					success += list.size();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				failed += list.size();
			}
		}
		long endDate = System.currentTimeMillis();
		System.out.println("数据写入文件结束，成功："+success+", 失败："+failed+", 耗时："+(endDate - startDate) / 1000 + " s");
	}
}
