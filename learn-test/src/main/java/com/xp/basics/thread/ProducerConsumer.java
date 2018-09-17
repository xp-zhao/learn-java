package com.xp.basics.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xp-zhao on 2018/9/14.
 */
public class ProducerConsumer
{
	private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
	private static class Producer extends Thread{
		@Override
		public void run(){
			try
			{
				queue.put("producer");
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.print("producer...");
		}
	}
	private static class Consumer extends Thread{
		@Override
		public void run(){
			try
			{
				queue.take();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.print("consumeer...");
		}
	}

	public static void main(String[] args)
	{
		for(int i = 0; i < 2; i++){
			Producer producer = new Producer();
			producer.start();
		}
		for(int i = 0; i < 5; i++){
			Consumer consumer = new Consumer();
			consumer.start();
		}
		for(int i = 0; i < 3; i++){
			Producer producer = new Producer();
			producer.start();
		}
	}
}
