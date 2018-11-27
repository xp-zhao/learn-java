package com.xp.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xp-zhao on 2018/11/27.
 */
public class Test
{
	public static void main(String[] args) {

		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green" , 10));
		apples.add(new Apple("green" , 20));
		apples.add(new Apple("green" , 30));
		apples.add(new Apple("red" , 10));
		apples.add(new Apple("red" , 20));
		System.out.println(filterApples(apples,new AppleGreenColorPredicate()));
		System.out.println(filterApples(apples,new AppleHeavyWeightPredicate()));
		System.out.println("-------------------------------");
		prettyPrintApple(apples,new AppleFancyFormatter());
		System.out.println("-------------------------------");
		prettyPrintApple(apples,new AppleSimpleFormatter());
		System.out.println("-------------------------------");
		System.out.println(filterApples(apples , new ApplePredicate()
		{
			@Override
			public boolean test(Apple apple)
			{
				return "red".equals(apple.getColor());
			}
		}));
		System.out.println("-------------------------------");
		System.out.println(filterApples(apples,(Apple apple) -> "red".equals(apple.getColor())));
		System.out.println("-------------------------------");
		System.out.println(filter(apples,(Apple apple) -> "red".equals(apple.getColor())));
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(filter(nums,(Integer num) -> num % 2 == 0));
		System.out.println("-------------------------------");
		Thread t = new Thread(new Runnable()
		{
			@Override public void run()
			{
				System.out.println("hello world");
			}
		});
		t.start();
		Thread thread = new Thread(() -> System.out.println("hello world"));
		thread.start();
	}

	public static List<Apple> filterApples(List<Apple>  inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory)
		{
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
		for(Apple apple : inventory)
		{
			System.out.println(formatter.accept(apple));
		}
	}

	public static <T> List<T> filter(List<T> list,Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T t : list)
		{
			if(p.test(t))
			{
				result.add(t);
			}
		}
		return result;
	}
}
