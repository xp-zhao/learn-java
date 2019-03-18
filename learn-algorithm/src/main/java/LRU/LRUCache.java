package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最简单的 LRU 算法
 * Created by xp-zhao on 2018/12/24.
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V>
{
	private final int CACHE_SIZE;

	public LRUCache(int cacheSize){
		super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
		CACHE_SIZE = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		return size() > CACHE_SIZE;
	}

	public static void main(String[] args) {
		LRUCache<String, Integer> map = new LRUCache<>(4);
		map.put("1",1);
		map.put("2",2);
		map.put("3",3);
		map.put("4",4);
		map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
		System.out.println("******************************");
		map.get("1");
		map.put("5" , 5);
		map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
	}
}
