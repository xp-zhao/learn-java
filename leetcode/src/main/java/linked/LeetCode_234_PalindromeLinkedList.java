package linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。

 示例 1:
 输入: 1->2
 输出: false

 示例 2:
 输入: 1->2->2->1
 输出: true
 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * Created by xp-zhao on 2019/1/7.
 */
public class LeetCode_234_PalindromeLinkedList
{
	public static void main(String[] args) {
//		int[] nums = {-129 , -129};
//		int[] nums = {1 , 2 , 2 , 1};
		int[] nums = {1 , 2};
		ListNode node = new ListNode(nums);
		System.out.println(isPalindrome1(node));
	}

	public static boolean isPalindrome(ListNode head) {
		List<Integer> nums = new ArrayList<>();
		while(head != null){
			nums.add(head.value);
			head = head.next;
		}
		for(int i = 0; i < nums.size() >> 1; i++)
		{
			if(!nums.get(i).equals(nums.get(nums.size() - i - 1)))
			{
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrome1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		// 找到链表的中间节点
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		// 反转中间节点之后的链表
		ListNode prev = null;
		ListNode next;
		while(slow != null){
			next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}
		// 比较
		while(prev != null){
			if(prev.value != head.value){
				return false;
			}
			prev = prev.next;
			head = head.next;
		}
		return true;
	}
}
