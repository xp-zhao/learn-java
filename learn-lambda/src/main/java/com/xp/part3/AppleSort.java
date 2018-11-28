package com.xp.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by xp-zhao on 2018/11/28.
 */
public class AppleSort
{
	public static void main(String[] args) {
		List<Apple> list = Arrays.asList(
			new Apple("green" , 10) ,
			new Apple("green" , 20),
			new Apple("red",30),
			new Apple("red",20),
			new Apple("green",30));
		// 1. 实现 Comparator 接口
		System.out.println(list);
//		System.out.println("1. 实现 Comparator 接口");
		//		list.sort(new AppleComparator());
//		System.out.println(list);
		// 2. 使用匿名类
//		System.out.println("2. 使用匿名类");
//		list.sort(new Comparator<Apple>()
//		{
//			@Override public int compare(Apple o1 , Apple o2)
//			{
//				return o1.getWeight().compareTo(o2.getWeight());
//			}
//		});
//		System.out.println(list);
		// 3. lambda 表达式
//		list.sort((Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
//		list.sort((a1,a2) -> a1.getWeight().compareTo(a2.getWeight()));
//		list.sort(Comparator.comparing(a -> a.getWeight()));
		list.sort(Comparator.comparing(Apple::getWeight).reversed());
		System.out.println(list);
		System.out.println("----------------------");
		// 红苹果
		Predicate<Apple> redApple = (Apple a) -> "red".equals(a.getColor());
		// 非红苹果
		Predicate<Apple> notRedApple = redApple.negate();
		System.out.println(filter(list,notRedApple));
		// 红苹果并且重量大于 20
		System.out.println(filter(list,redApple.and(a -> a.getWeight() > 20)));
		// 红苹果并且重量大于 20 或者绿苹果
		System.out.println(filter(list,redApple.and(a -> a.getWeight() > 20).or(a -> "green".equals(a.getColor()))));
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
