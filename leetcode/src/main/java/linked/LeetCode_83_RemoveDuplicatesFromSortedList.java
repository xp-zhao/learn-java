package linked;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:
 输入: 1->1->2
 输出: 1->2

 示例 2:
 输入: 1->1->2->3->3
 输出: 1->2->3
 * Created by xp-zhao on 2019/1/7.
 */
public class LeetCode_83_RemoveDuplicatesFromSortedList
{
	public static void main(String[] args) {
		int[] nums = {1 , 1 , 1};
//		int[] nums = {1 , 1 , 2 , 3 , 3};
		ListNode node = new ListNode(nums);
		System.out.println(node);
		System.out.println(deleteDuplicates(node));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while(current != null && current.next != null){
			if(current.value == current.next.value){
				current.next = current.next.next;
			}else{
				current = current.next;
			}
		}
		return head;
	}
}
