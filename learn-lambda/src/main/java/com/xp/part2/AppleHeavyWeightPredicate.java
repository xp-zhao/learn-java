package com.xp.part2;

/**
 * Created by xp-zhao on 2018/11/27.
 */
public class AppleHeavyWeightPredicate implements ApplePredicate
{
	@Override
	public boolean test(Apple apple)
	{
		return apple.getWeight() > 20;
	}
}
