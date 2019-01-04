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
		ListNode node = createLinked();
		printLinked(node);
		ListNode result = reverse(node);
		printLinked(result);
	}

	public static ListNode reverse(ListNode current){
		ListNode previous = null;
		ListNode next;
		while(current != null){
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		return previous;
	}

	public static ListNode createLinked(){
		ListNode head = new ListNode(1);
		ListNode next = new ListNode(2);
		ListNode nextNext = new ListNode(3);
		head.setNext(next);
		next.setNext(nextNext);
		return head;
	}

	public static void printLinked(ListNode node){
		List<Integer> list = new ArrayList<>();
		while(node != null){
			list.add(node.getValue());
			node = node.getNext();
		}
		System.out.println(StringUtils.join(list.toArray(),"->"));
	}
}
