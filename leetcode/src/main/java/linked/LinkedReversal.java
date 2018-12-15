package linked;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表反转
 * Created by xp-zhao on 2018/12/11.
 */
public class LinkedReversal
{
	public static void main(String[] args) {
		LinkedNode node = createLinked();
		printLinked(node);
		LinkedNode result = reverse(node);
		printLinked(result);
	}

	public static LinkedNode reverse(LinkedNode current){
		LinkedNode previous = null;
		LinkedNode next;
		while(current != null){
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		return previous;
	}

	public static LinkedNode createLinked(){
		LinkedNode head = new LinkedNode(1);
		LinkedNode next = new LinkedNode(2);
		LinkedNode nextNext = new LinkedNode(3);
		head.setNext(next);
		next.setNext(nextNext);
		return head;
	}

	public static void printLinked(LinkedNode node){
		List<Integer> list = new ArrayList<>();
		while(node != null){
			list.add(node.getValue());
			node = node.getNext();
		}
		System.out.println(StringUtils.join(list.toArray(),"->"));
	}
}
