package com.xp.List;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xp-zhao on 2018/5/10.
 */
public class Iterator
{
	public static void main(String[] args)
	{
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for(String feature : features)
		{
			System.out.println(feature);
		}
		System.out.println("***********************");
		features.forEach(n -> System.out.println(n));
	}
}
