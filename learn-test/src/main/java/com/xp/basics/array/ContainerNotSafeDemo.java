package com.xp.basics.array;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 * ArrayList
 *

 *
 *
 * Created by xp-zhao on 2019/4/18.
 */
public class ContainerNotSafeDemo
{
	public static void main(String[] args) {
		Map<String, String> map = new ConcurrentHashMap<>();
		for(int i = 1; i <= 30; i++)
		{
			new Thread(() -> {
				map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
	}

	private static void setNotSafe()
	{
		//		Set<String> set = Collections.synchronizedSet(new HashSet<>());
		Set<String> set = new CopyOnWriteArraySet<>();
		for(int i = 1; i <= 30; i++)
		{
			new Thread(() -> {
				set.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(set);
			},String.valueOf(i)).start();
		}
		new HashSet<>().add("a");
	}

	private static void listNotSafe()
	{
		//		List<String> list = Arrays.asList("a" , "b" , "c");
		//		list.forEach(System.out::println);
		//		List<String> list = new Vector<>();
		//		List<String> list = Collections.synchronizedList(new ArrayList<>());
		List<String> list = new CopyOnWriteArrayList<>();
		for(int i = 1; i <= 30; i++)
		{
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(list);
			},String.valueOf(i)).start();
		}
		/**
		 *  * 1. 故障现象
		 *  * 	java.util.ConcurrentModificationException
		 *  * 2. 导致原因
		 *  *	并发争抢修改导致
		 *  * 3. 解决方案
		 *  * 	1. new Vector<>()
		 *  * 	2. Collections.synchronizedList(new ArrayList<>())
		 *  * 	3. new CopyOnWriteArrayList<>()
		 *  * 4. 优化建议（同样的错误不能犯第二次）
		 */}
}
