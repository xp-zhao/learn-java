package com.xp.AbstractProduct;

/**
 * Created by xp-zhao on 2018/9/30.
 */
public class Client
{
	public static void main(String[] args)
	{
		AbstractFactory factory = new ConcreteFactory1();
		AbstractProductA productA = factory.createProductA();
		AbstractProductB productB = factory.createProductB();
	}
}
