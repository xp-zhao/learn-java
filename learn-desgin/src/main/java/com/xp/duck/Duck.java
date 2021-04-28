package com.xp.duck;

import com.xp.duck.fly.FlyBehavior;
import com.xp.duck.quack.QuackBehavior;

/**
 * 策略模式示例代码
 * Created by xp-zhao on 2018/4/16.
 */
public abstract class Duck
{
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public void performQuack(){
		quackBehavior.quack();
	}

	public void performFly(){
		flyBehavior.fly();
	}

	public void swim(){
		System.out.println("all ducks float,even decoys");
 	}

	public abstract void display();

	public void setFlyBehavior(FlyBehavior flyBehavior)
	{
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior)
	{
		this.quackBehavior = quackBehavior;
	}
}

