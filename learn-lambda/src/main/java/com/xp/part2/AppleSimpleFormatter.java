package com.xp.part2;

/**
 * Created by xp-zhao on 2018/11/27.
 */
public class AppleSimpleFormatter implements AppleFormatter
{
	@Override
	public String accept(Apple apple)
	{
		return "An apple of " + apple.getWeight() + "g";
	}
}
