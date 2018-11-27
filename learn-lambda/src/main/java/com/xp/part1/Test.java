package com.xp.part1;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by xp-zhao on 2018/11/26.
 */
public class Test
{
	public static void main(String[] args){
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green" , 10));
		apples.add(new Apple("green" , 20));
		apples.add(new Apple("green" , 30));
		apples.add(new Apple("red" , 10));
		apples.add(new Apple("red" , 20));
		System.out.println(filterGreenApples(apples));
		System.out.println(filterWeightApples(apples));
		System.out.println("---------------------------------------");
		System.out.println(filterApples(apples,Test::isGreenApple));
		System.out.println(filterApples(apples,Test::isHeavyApple));
		System.out.println("---------------------------------------");
		System.out.println(filterApples(apples,(Apple a) -> "green".equals(a.getColor())));
		System.out.println(filterApples(apples,(Apple a) -> a.getWeight() > 10));
		System.out.println(filterApples(apples,(Apple a) -> a.getWeight() > 20 && "green".equals(a.getColor())));
		System.out.println("---------------------------------------");
		System.out.println(apples.stream().filter((Apple a) -> a.getWeight() > 10).collect(toList()));
	}

	private static List<Apple> filterWeightApples(List<Apple> apples)
	{
		List<Apple> result = new ArrayList<>();
		for(Apple apple : apples)
		{
			if(apple.getWeight() > 10)
			{
				result.add(apple);
			}
		}
		return result;
	}

	private static List<Apple> filterGreenApples(List<Apple> apples)
	{
		List<Apple> result = new ArrayList<>();
		for(Apple apple : apples)
		{
			if("green".equals(apple.getColor()))
			{
				result.add(apple);
			}
		}
		return result;
	}

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 10;
	}

	public static List<Apple> filterApples(List<Apple> apples,Predicate<Apple> p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : apples)
		{
			if(p.test(apple))
			{
				result.add(apple);
			}
		}
		return result;
	}
}
