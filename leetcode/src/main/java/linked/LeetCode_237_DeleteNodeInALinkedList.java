package linked;

/**
 * 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 4 -> 5 -> 1 -> 9

 示例 1:

 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

 示例 2:

 输入: head = [4,5,1,9], node = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

 说明:

 链表至少包含两个节点。
 链表中所有节点的值都是唯一的。
 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 不要从你的函数中返回任何结果。
 * Created by xp-zhao on 2019/1/7.
 */
public class LeetCode_237_DeleteNodeInALinkedList
{
	public static void main(String[] args) {
		int[] nums = {4 , 5 , 1 , 9};
		ListNode node = new ListNode(nums);
		System.out.println(node);
		deleteNode(node, 5);
		System.out.println(node);
	}

	public static void deleteNode(ListNode node, int num) {
		while(node != null){
			if(node.value == num){
				node.value = node.next.value;
				node.next = node.next.next;
				return;
			}
			node = node.next;
		}
	}
}
