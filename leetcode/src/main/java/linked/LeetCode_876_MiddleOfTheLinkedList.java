package linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 876. 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 如果有两个中间结点，则返回第二个中间结点。

 示例 1：

 输入：[1,2,3,4,5]
 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.

 示例 2：

 输入：[1,2,3,4,5,6]
 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。

 提示：
 给定链表的结点数介于 1 和 100 之间。
 * Created by xp-zhao on 2019/1/7.
 */
public class LeetCode_876_MiddleOfTheLinkedList
{
	public static void main(String[] args) {
		int[] nums = {1 , 2 , 3 , 4 , 5, 6};
		ListNode node = new ListNode(nums);
		System.out.println(node);
		System.out.println(middleNode1(node));
	}

	public static ListNode middleNode(ListNode head) {
		List<ListNode> nodes = new ArrayList<>();
		while(head != null){
			nodes.add(head);
			head = head.next;
		}
		return nodes.get(nodes.size() >> 1);
	}

	/**
	 * 官方解法
	 * 快慢指针：当用慢指针 slow 遍历链表时，让一个快指针 fast 的速度是它的两倍。当 fast 到达链表的末尾时，slow 指针必然位于中间。
	 * @param head
	 * @return
	 */
	public static ListNode middleNode1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
