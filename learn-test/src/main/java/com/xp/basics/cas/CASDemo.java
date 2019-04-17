package com.xp.basics.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas -> compare and swap
 * 比较并交换
 * Created by xp-zhao on 2019/4/17.
 */
public class CASDemo
{
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(5);
		System.out.println(atomicInteger.compareAndSet(5 , 6) + " current data: "+ atomicInteger.get());
		System.out.println(atomicInteger.compareAndSet(5 , 7) + " current data: "+ atomicInteger.get());
	}
}
