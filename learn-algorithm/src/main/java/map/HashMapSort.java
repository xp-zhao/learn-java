package map;

import java.util.*;

/**
 * 已知一个 HashMap<Integer，User>集合， User 有 name（String）和 age（int）属性。
 * 请写一个方法实现对 HashMap 的排序功能，该方法接收 HashMap<Integer，User>为形参，返回类型为 HashMap<Integer，User>，
 *  要求对 HashMap 中的 User 的 age 倒序进行排序。排序时 key=value 键值对不得拆散。
 * Created by xp-zhao on 2019/2/22.
 */
public class HashMapSort
{
	public static void main(String[] args) {
		System.out.println(getNum(0.1));
		HashMap<Integer, User> map = new HashMap<>();
		map.put(1 , new User(25 , "张三"));
		map.put(3 , new User(22 , "李四"));
		map.put(2 , new User(28 , "王五"));
		System.out.println(map);
		System.out.println(sortHashMap(map));
	}

	public static HashMap<Integer,User> sortHashMap(HashMap<Integer, User> map){
		Set<Map.Entry<Integer, User>> set = map.entrySet();
		List<Map.Entry<Integer, User>> list = new ArrayList<>(set);
		Collections.sort(list , (o1 , o2) -> o2.getValue().getAge() - o1.getValue().getAge());
		LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
		for(Map.Entry<Integer, User> entry : list)
		{
			linkedHashMap.put(entry.getKey() , entry.getValue());
		}
		return linkedHashMap;
	}

	public static int getNum(int n){
		return (int) Math.pow(10 , n);
//		char[] ch = new char[n];
//		Arrays.fill(ch, '0');
//		String result = "1" + new String(ch);
//		return Integer.valueOf(result);
	}

	public static int getNum(double n){
		String str = String.valueOf(n);
		int index = str.indexOf('.');
		int result = str.length() - index - 1;
		return (int) Math.pow(10 , result);
	}
}
