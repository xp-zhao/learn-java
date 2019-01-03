package com.xp.optional;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xp-zhao on 2019/1/3.
 */
public class OptionalDemo
{
	public static void main(String[] args) {
		Optional<String> optional = Optional.of("a");
		System.out.println(optional.get());
		Optional empty = Optional.empty();
		System.out.println(optional.isPresent());
		System.out.println(empty.orElse("b"));
		System.out.println(empty.orElseGet(()->"c"));
//		List<Integer> nums = Arrays.asList(1 , 2 , 3 , 4);
		Set<Integer> nums = new HashSet<>(Arrays.asList(1 , 2 , 3 , 4));
		List<Integer> nums1 = nums.stream().collect(Collectors.toList());
		System.out.println(CollectionUtils.isEqualCollection(nums,nums1));
	}
}
