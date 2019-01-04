package linked;

/**
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。

 示例:
 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 *
 * Created by xp-zhao on 2019/1/4.
 */
public class LeetCode_203_RemoveLinkedListElements
{
	public static void main(String[] args) {
		int[] nums = {1 , 2 , 6 , 3 , 4 , 5 , 6};
		ListNode head = new ListNode(nums);
		System.out.println(head);
//		System.out.println(new LeetCode_203_RemoveLinkedListElements().removeElements(head , 6));
		System.out.println(new LeetCode_203_RemoveLinkedListElements().removeElements1(head , 6));
	}

	public ListNode removeElements(ListNode head, int val) {
		while(head != null && head.value == val){
			ListNode delNode = head;
			head = head.next;
			delNode.next = null;
		}
		if(head == null){
			return null;
		}
		ListNode prev = head;
		while(prev.next != null){
			if(prev.next.value == val){
				ListNode delNode = prev.next;
				prev.next = delNode.next;
				delNode.next = null;
			}else{
				prev = prev.next;
			}
		}
		return head;
	}

	public ListNode removeElements1(ListNode head, int val) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;

		ListNode prev = dummyHead;
		while(prev.next != null){
			if(prev.next.value == val){
//				ListNode delNode = prev.next;
//				prev.next = delNode.next;
//				delNode.next = null;
				prev.next = prev.next.next;
			}else{
				prev = prev.next;
			}
		}
		return dummyHead.next;
	}
}
