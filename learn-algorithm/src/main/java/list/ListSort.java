package list;

import map.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xp-zhao on 2019/3/4.
 */
public class ListSort
{
	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		list.add(new User(25 , "张三"));
		list.add(new User(22 , "李四"));
		list.add(new User(28 , "王五"));
		System.out.println(list);
//		Collections.sort(list , (o1 , o2) -> o2.getAge() - o1.getAge());
		System.out.println(list);
		System.out.println(
			list.stream().sorted((u1 , u2) -> u2.getAge() - u1.getAge()).collect(Collectors.toList()));
	}
}
