package com.xp.thread.FutrueDemo;

import com.xp.utils.FileUtils;

import java.io.File;
import java.util.concurrent.*;

/**
 * Created by xp-zhao on 2018/9/7.
 */
public class FutrueExample
{
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		deleteFile();
//		long startTime = System.currentTimeMillis();
//		ExecutorService service = Executors.newFixedThreadPool(1);
//		// 第一步上传歌单文件
//		Callable<Boolean> playlist = new PlayList();
//		FutureTask<Boolean> task = new FutureTask<>(playlist);
//		service.submit(task);
//		service.shutdown();
////		new Thread(task).start();
//		TimeUnit.SECONDS.sleep(2); // 模拟生成歌曲文件的时间
//		System.out.println("第二步：歌曲文件生成成功");
//		if(!task.isDone())
//		{
//			System.out.println("第二步：歌单文件未上传结束");
//		}
//		if(task.get())
//		{
//			System.out.println("第二步：上传歌曲文件");
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("总共耗时："+(endTime - startTime) / 1000 + " s");
	}


	// 歌单文件处理线程
	static class PlayList implements Callable<Boolean>{
		private boolean isEnd = false;

		@Override public Boolean call() throws Exception
		{
			System.out.println("第一步：开始上传歌单文件");
			try
			{
				TimeUnit.SECONDS.sleep(5); // 模拟处理时间
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("第一步：上传歌单文件结束");
			isEnd = true;
			return isEnd;
		}
	}

	public static void deleteFile(){
		File file = new File("D:\\home\\liujf\\playlistinfo");
		FileUtils.deleteFile(file);
	}
}
