package com.xp.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by xp-zhao on 2018/11/28.
 */
public class PredicateDemo
{
	public static void main(String[] args) {
		List<String> list = Arrays.asList("121" , "" , "234234" , "" , "2342");
		System.out.println(filter(list,(String s) -> !s.isEmpty()));
		System.out.println(filter(list,(String s) -> s.isEmpty()));
		IntPredicate predicate = (int i) -> i % 2 == 0;
		System.out.println(predicate.test(100));
	}

	public static <T> List<T> filter(List<T> list,Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T t : list)
		{
			if(p.test(t))
			{
				result.add(t);
			}
		}
		return result;
	}
}
