package linked;

/**
 * 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 示例 1:

 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

 示例 2:
 输入: head = [4,5,1,9], node = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * Created by xp-zhao on 2019/1/21.
 */
public class LeetCode_237_DeleteNodeInALinkedList
{
	public static void main(String[] args){
		int[] nums = {4 , 5 , 1 , 9};
		ListNode node = new ListNode(nums);
		System.out.println(node);
		deleteNode(node);
		System.out.println(node);
	}

	public static void deleteNode(ListNode node) {
		node.value = node.next.value;
		node.next = node.next.next;
	}
}
