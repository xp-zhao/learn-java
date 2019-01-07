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
//		System.out.println(new LeetCode_203_RemoveLinkedListElements().removeElements1(head , 6));
		System.out.println(new LeetCode_203_RemoveLinkedListElements().removeElements2(head , 6, 0));
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

	/**
	 * 递归调用
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements2(ListNode head, int val, int depth){
		String depthString = generateDepthString(depth);
		System.out.print(depthString);
		System.out.println("Call: remove " + val + " in " + head);
		if(head == null){
			System.out.print(depthString);
			System.out.println("Return: " + head);
			return null;
		}
		ListNode temp = head.next = removeElements2(head.next , val, depth + 1);
		System.out.print(depthString);
		System.out.println("After remote " + val + ": " + temp);

		ListNode ret;
		if(head.value == val){
			ret = temp;
		}else{
			head.next = temp;
			ret = head;
		}
		System.out.print(depthString);
		System.out.println("Return: " + ret);
		return head.value == val ? head.next : head;
	}

	private String generateDepthString(int depth){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < depth; i++)
		{
			sb.append("--");
		}
		return sb.toString();
	}
}
