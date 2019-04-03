package com.xp.basics.hash;

import java.util.HashMap;

/**
 * Created by xp-zhao on 2019/4/3.
 */
public class WithOutHashCode
{
	public static void main(String[] args) {
		Key k1 = new Key(1);
		Key k2 = new Key(1);
		HashMap<Key, String> map = new HashMap<>();
		map.put(k1 , "key with id is 1");
		System.out.println(map.get(k2));
	}
}
