package com.xp.Predicate;

import com.xp.part2.Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xp-zhao on 2018/5/18.
 */
public class Demo1
{
	public static void main(String[] args)
	{
		List<String> languages = Arrays.asList("Java" , "Scala" , "C++" , "Lisp" , "Haskell");
		Predicate<Integer> result = x -> x > 5;
//		ThreadLocal<DateTimeFormatter> formatter = ThreadLocal.withInitial(() -> new DateTimeFormatter());
//		List<String> collected = Stream.of("a","b","c").map(str -> str.toUpperCase()).collect(Collectors.toList());
//		List<String> collected = Stream.of("a","b","c").filter(s -> s.equals("a")).collect(Collectors.toList());
		List<Integer> collected = Stream.of(Arrays.asList(1 , 2) , Arrays.asList(3 , 4))
			.flatMap(num -> num.stream()).collect(Collectors.toList());
		int count = collected.stream().reduce(0,(acc,element) -> acc + element);
		System.out.println(collected);
		System.out.println(count);
	}

}
