package com.xp.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/12/28.
 */
public class MapDemo
{
	public static void main(String[] args){
		Map<String, Integer> map = new HashMap<>();
		map.put("1" , 1);
		map.put("2" , 2);
		map.put("3" , 3);
		map.put("4" , 4);
		map.put("5" , 5);
		map.forEach((k,v) -> System.out.println(k + "=" + v));
	}
}
