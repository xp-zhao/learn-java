package com.xp.basics.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xp-zhao on 2019/3/20.
 */
public class EqualDemo
{
	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "a" + "b";
		System.out.println(s1 == s2);
		List<String> list = new ArrayList<>(Arrays.asList("a", "b",  "b" , "c", "d"));
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String ele = iterator.next();
			if(ele.equals("b")){
				iterator.remove();
			}
		}
		System.out.println(list);
	}
}
