package com.xp.part3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by xp-zhao on 2018/11/28.
 */
public class ConsumerDemo
{
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1 , 2 , 3 , 4 , 7 , 6);
		forEach(list,((Integer integer) -> System.out.println(integer)));
		list.forEach(n -> System.out.println(n));
	}

	public static <T> void forEach(List<T> list,Consumer<T> c){
		for(T t : list)
		{
			c.accept(t);

		}
	}
}
