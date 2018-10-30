package com.xp.basics.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xp-zhao on 2018/10/8.
 */
public class ArrayListDemo
{
	public static void main(String[] args)
	{
		System.out.println(45 >>> 16);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
//		for(Integer integer : list){
//			System.out.println(integer);
//		}
		Iterator<Integer> iterator =  list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
