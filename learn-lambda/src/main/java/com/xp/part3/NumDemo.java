package com.xp.part3;

import java.util.function.Function;

/**
 * Created by xp-zhao on 2018/11/28.
 */
public class NumDemo
{
	public static void main(String[] args) {
	    // 函数复合
		Function<Integer,Integer> f = x -> x + 1;
		Function<Integer,Integer> g = x -> x * 2;
		Function<Integer,Integer> h = f.andThen(g);
		Function<Integer,Integer> j = f.compose(g);
		System.out.println(h.apply(1));
		System.out.println(j.apply(1));
	}
}
