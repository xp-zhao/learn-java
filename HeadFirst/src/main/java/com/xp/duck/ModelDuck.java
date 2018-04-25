package com.xp.duck;

import com.xp.duck.fly.FlyNoWay;
import com.xp.duck.fly.FlyWithWings;
import com.xp.duck.quack.Quack;

/**
 * Created by xp-zhao on 2018/4/16.
 */
public class ModelDuck extends Duck
{
	public ModelDuck()
	{
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display()
	{
		System.out.println("I'm a model duck");
	}
}
