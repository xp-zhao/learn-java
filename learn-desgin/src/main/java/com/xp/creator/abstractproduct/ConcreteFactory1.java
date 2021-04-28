package com.xp.creator.abstractproduct;

/**
 * Created by xp-zhao on 2018/9/30.
 */
public class ConcreteFactory1 extends AbstractFactory
{
	AbstractProductA createProductA()
	{
		return new ProductA1();
	}

	AbstractProductB createProductB()
	{
		return new ProductB1();
	}
}
