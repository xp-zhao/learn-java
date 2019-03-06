package linked;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * Created by xp-zhao on 2019/3/6.
 */
public class LeetCode_142_LinkedListCycleii
{
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean hasCycle = false;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				hasCycle = true;
				break;
			}
		}
		if(hasCycle){
			fast = head;
			while(slow != fast){
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}else{
			return null;
		}
	}
}
