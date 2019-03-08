package com.xp.Thread;

import java.util.concurrent.TimeUnit;

/**
 * 简单的死锁示例
 * Created by xp-zhao on 2019/3/7.
 */
public class DeadLock
{
	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();

		new Thread(() -> {
			synchronized (a){
				System.out.println("线程 A 获取了 a 锁");
				try
				{
					TimeUnit.SECONDS.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (b){
					System.out.println("线程 A 获取了 b 锁");
				}
			}
		},"A").start();
		new Thread(() -> {
			synchronized (b){
				System.out.println("线程 B 获取了 b 锁");
				try
				{
					TimeUnit.SECONDS.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (a){
					System.out.println("线程 B 获取了 a 锁");
				}
			}
		},"B").start();
	}
}
