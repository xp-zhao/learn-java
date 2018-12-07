package com.xp.part5_stream;

import com.xp.part4_stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xp-zhao on 2018/12/7.
 */
public class UseDemo
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
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
			.map( i -> i * i)
			.distinct()
			.forEach(System.out::println);
		List<Integer> dishes = menu.stream()
					.map(Dish::getName)
					.map(String::length)
					.collect(Collectors.toList());
		System.out.println(dishes);
		List<String> title = Arrays.asList("Java8" , "In" , "Action");
		List<String> lengths = title.stream()
			.map(word -> word.split(""))
			.flatMap(Arrays::stream)
			.distinct()
			.collect(Collectors.toList());
		System.out.println(lengths);
		List<Integer> nums1 = Arrays.asList(1 , 2 , 3);
		List<Integer> nums2 = Arrays.asList(3 , 4);
		List<int[]> result = nums1.stream()
			.flatMap(i -> nums2.stream()
				           .filter(j -> (i + j) % 3 == 0)
			   	 	   .map(j -> new int[]{i,j})
			)
			.collect(Collectors.toList());
		for(int[] ints : result)
		{
			System.out.println(Arrays.toString(ints));
		}
		List<Integer> nums = Arrays.asList(1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10);
		System.out.println(nums.stream().reduce(0,Integer::sum));
		System.out.println(nums.stream().reduce(1,(a,b) -> a * b));
	}
}
