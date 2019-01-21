package linked;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * Created by xp-zhao on 2019/1/7.
 */
public class LeetCode_141_LinkedListCycle
{
	public static void main(String[] args) {
	}

	public static boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null){
			if(set.contains(head)){
				return true;
			}else{
				set.add(head);
			}
			head = head.next;
		}
		return false;
	}

	/**
	 * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。慢指针每次移动一步，而快指针每次移动两步。
	 * @param head
	 * @return
	 */
	public static boolean hasCycle1(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

}
