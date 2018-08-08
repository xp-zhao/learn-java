/**
      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
      输出：7 -> 0 -> 8
      原因：342 + 465 = 807
 * Created by xp-zhao on 2018/8/7.
 */
public class AddTwoNum
{
	public static void main(String[] args)
	{
		int[] array1 = {5,6,4};
		int[] array2 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		ListNode node1 = transfer(array1);
		ListNode node2 = transfer(array2);
		Answer(node1,node2);

	}

	public static void Answer(ListNode node1,ListNode node2)
	{
		ListNode tempNode = new ListNode(0);
		ListNode l1 = node1;
		ListNode l2 = node2;
		ListNode temp = tempNode;
		int carry = 0;
		while(l1 != null || l2 != null){
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
			if(l1 != null){
				l1 = l1.next;
			}
			if(l2 != null){
				l2 = l2.next;
			}
		}
		if(carry > 0){
			temp.next = new ListNode(carry);
		}
		printNode(tempNode.next);
	}

	public static void test(ListNode node1,ListNode node2)
	{
		StringBuffer sbNode1 = new StringBuffer("");
		NodeReverse(node1,sbNode1);
		System.out.println(sbNode1.toString());
		long num1 = Long.parseLong(sbNode1.toString());

		StringBuffer sbNode2 = new StringBuffer("");
		NodeReverse(node2,sbNode2);
		System.out.println(sbNode2.toString());
		long num2 = Long.parseLong(sbNode2.toString());

		long result = num1 + num2;
		System.out.println("result: "+result);
		String str = String.valueOf(result);
		char[] ch = str.toCharArray();

		ListNode head = null;
		ListNode tail = null;
		for(int i = ch.length-1; i >= 0; i--){
			if(head == null){
				tail = new ListNode(ch[i]-'0');
				head = tail;
			} else{
				tail.next = new ListNode(ch[i] - '0');
				tail = tail.next;
			}
			tail.next = null;
		}
		printNode(head);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		return null;
	}

	public static void printNode(ListNode node){
		while(node != null){
			if(node.next == null){
				System.out.println(node.val);
			}else{
				System.out.print(node.val+">");
			}
			node = node.next;
		}
		System.out.println();
	}

	private static void printNodeReverse(ListNode node){
		if(node != null)
		{
			printNodeReverse(node.next);
			System.out.print(node.val+"-");
		}
	}

	/**
	 * 链表反转
	 * @param node
	 * @param sb
	 */
	private static void NodeReverse(ListNode node,StringBuffer sb){
		if(node != null){
			NodeReverse(node.next,sb);
			sb.append(node.val);
		}
	}

	/**
	 * 数组转链表
	 * @param array
	 * @return
	 */
	private static ListNode transfer(int[] array){
		if(array == null){
			return null;
		}
		ListNode head = null;
		ListNode tail = null;
		for(int i = 0; i < array.length; i++){
			if(head == null){
				tail = new ListNode(array[i]);
				head = tail;
			} else{
				tail.next = new ListNode(array[i]);
				tail = tail.next;
			}
			tail.next = null;
		}
		return head;
	}

	static class ListNode{
		int val;
		ListNode next;
		ListNode (int x){
			val = x;
		}
	}
}
