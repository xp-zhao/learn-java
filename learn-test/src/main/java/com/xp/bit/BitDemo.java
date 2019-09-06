package com.xp.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xp-zhao on 2018/12/6.
 */
public class BitDemo
{
	public static void main(String[] args) {
		System.out.println(0 ^ 4);
		System.out.println(true && true);
		byte b1 = -12;
		byte b2 = -12;
		byte b3 = (byte) (b1 + b2);
		System.out.println(b3);
		int num = 99;
		System.out.println(num * 2);
		System.out.println(num << 1);

		List<Map<String, String>> list = new ArrayList<>();
		List<Map<String, Object>> result = list.stream().map(item -> {
			return new HashMap<String, Object>(item);
		}).collect(Collectors.toList());
		System.out.println(result);
	}
}
