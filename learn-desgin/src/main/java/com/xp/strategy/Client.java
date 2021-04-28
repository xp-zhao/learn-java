package com.xp.strategy;

/**
 * Created by xp-zhao on 2019/3/21.
 */
public class Client
{
	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.execute(10, 5));
		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.execute(10, 5));
		context = new Context(new OperationMultiply());
		System.out.println("10 * 5 = " + context.execute(10, 5));
	}
}
