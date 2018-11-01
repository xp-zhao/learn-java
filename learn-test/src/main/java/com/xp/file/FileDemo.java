package com.xp.file;

import java.io.*;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xp-zhao on 2018/11/1.
 */
public class FileDemo
{


	public static void main(String[] args) throws IOException
	{
		BlockingQueue<List<String>> queue = new LinkedBlockingDeque<>(100);
		ExecutorService service = Executors.newFixedThreadPool(2);
		ReadFile readFile = new ReadFile(queue);
		WriteFile writeFile = new WriteFile(queue , readFile);
		service.submit(readFile);
		service.submit(writeFile);
	}
}
