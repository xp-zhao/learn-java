package com.xp.duck;

import com.xp.duck.fly.FlyWithWings;
import com.xp.duck.quack.Quack;

/**
 * Created by xp-zhao on 2018/4/16.
 */
public class MallardDuck extends Duck
{
	public MallardDuck(){
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public void display()
	{
		System.out.println("I'm a real Mallard duck");
	}
}
