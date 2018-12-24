package LRU;

import lombok.Data;

/**
 * Created by xp-zhao on 2018/12/24.
 */
@Data
public class Node<K,V>
{
	private K key;
	private V value;
	Node<K,V> tail;
	Node<K,V> next;
}
