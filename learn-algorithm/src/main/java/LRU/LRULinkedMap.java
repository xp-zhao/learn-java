package LRU;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 通过 LinkedHashMap 实现 LRU 算法（Least Recently Used 最近最少使用）
 * Created by xp-zhao on 2018/12/24.
 */
public class LRULinkedMap<K,V>
{
	private int cacheSize;
	private LinkedHashMap<K,V> cacheMap;

	public LRULinkedMap(final int cacheSize){
		this.cacheSize = cacheSize;
		cacheMap = new LinkedHashMap<K, V>(16,0.75F,true){
			@Override
			protected boolean removeEldestEntry(Map.Entry entry){
				if(cacheSize + 1 == cacheMap.size()){
					return true;
				}else{
					return false;
				}
			}
		};
	}

	public void put(K key,V value){
		cacheMap.put(key , value);
	}

	public V get(K key){
		return cacheMap.get(key);
	}

	public Collection<Map.Entry<K,V>> getAll(){
		return new ArrayList<Map.Entry<K, V>>(cacheMap.entrySet());
	}

	public static void main(String[] args) {
		LRULinkedMap<String, Integer> map = new LRULinkedMap<String, Integer>(4);
		map.put("1",1);
		map.put("2",2);
		map.put("3",3);
		map.put("4",4);
		for(Map.Entry<String,Integer> entry : map.getAll()){
			System.out.print(entry.getKey() + ":" + entry.getValue()+ "\t");
		}
		System.out.println();
		map.get("1");
		map.put("5",5);
		for(Map.Entry<String,Integer> entry : map.getAll()){
			System.out.print(entry.getKey() + ":" + entry.getValue()+ "\t");
		}
	}
}
