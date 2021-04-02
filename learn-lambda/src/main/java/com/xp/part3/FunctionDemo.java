package com.xp.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by xp-zhao on 2018/11/28.
 */
public class FunctionDemo
{
	public static void main(String[] args) {
		List<String> list = Arrays.asList("lambdas" , "in" , "action");
		System.out.println(map(list, String::length));
	}

	public static <T,R> List<R> map(List<T> list,Function<T,R> f){
		List<R> result = new ArrayList<>();
		for(T t : list)
		{
			result.add(f.apply(t));
		}
		return result;
	}
}
