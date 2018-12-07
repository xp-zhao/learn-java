package com.xp.part4_stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by xp-zhao on 2018/12/7.
 */
public class StreamDemo
{
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH) );
		List<String> threeHighCaloricDishNames = menu.stream()
			.filter(d -> {
				System.out.println("filtering " + d.getName());
				return d.getCalories() > 300;
			})
			.map(dish -> {
				System.out.println("mapping "+ dish.getName());
				return dish.getName();
			})
			.limit(3)
			.collect(toList());
		System.out.println(threeHighCaloricDishNames);
		List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());
		System.out.println(vegetarianDishes);
//		List<String> title = Arrays.asList("Java8" , "In" , "Action");
//		Stream<String> stream = title.stream();
//		stream.forEach(System.out::println);
//		stream.forEach(System.out::println);

	}
}
