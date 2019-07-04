package com.xp.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2019/2/22.
 */
public class ArrayListTest
{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		System.out.println(list.size());
		list.add(1);
		list.add(1);
		System.out.println(list.size());
		System.out.println(list.lastIndexOf(1));
	}
}
