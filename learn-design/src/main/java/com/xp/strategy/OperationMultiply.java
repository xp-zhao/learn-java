package com.xp.strategy;

/**
 * Created by xp-zhao on 2019/3/21.
 */
public class OperationMultiply implements Strategy
{
	@Override
	public int doOperation(int num1 , int num2)
	{
		return num1 * num2;
	}
}
