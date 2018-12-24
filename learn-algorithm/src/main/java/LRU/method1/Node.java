package LRU.method1;

import lombok.Data;

/**
 * Created by xp-zhao on 2018/12/24.
 */
@Data
public class Node
{
	private Node next;
	private Node pre;
	private Object key;
	private Object value;
	private Long updateTime;

	public Node(Node pre,Node next, Object key, Object val) {
		this.pre = pre ;
		this.next = next;
		this.key = key;
		this.value = val;
		this.updateTime = System.currentTimeMillis() ;
	}

	@Override
	public String toString() {
		return String.format("Node{key=%s, val=%s}" , key , value);
	}
}
