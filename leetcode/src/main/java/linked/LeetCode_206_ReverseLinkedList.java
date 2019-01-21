package linked;

/**
 * 206. 反转链表
 *反转一个单链表。

 示例:
 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题
 * Created by xp-zhao on 2019/1/7.
 */
public class LeetCode_206_ReverseLinkedList
{
	public static void main(String[] args) {
		int[] nums = {1 , 2 , 3 , 4 , 5};
		ListNode node = new ListNode(nums);
		System.out.println(node);
		System.out.println(reverseList(node));
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next;
		while(head != null){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
