package com.xp.duck;

import com.xp.duck.Duck;
import com.xp.duck.MallardDuck;
import com.xp.duck.fly.FlyRocketPowered;

/**
 * Created by xp-zhao on 2018/4/16.
 */
public class MiniDuckSimulator
{
	public static void main(String[] args)
	{
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		mallard.swim();
		mallard.display();

		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
