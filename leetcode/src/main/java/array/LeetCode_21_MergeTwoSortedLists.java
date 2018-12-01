package array;

import java.io.FileReader;

/**
 * 21. 合并两个有序链表
	 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

	 示例：
	 输入：1->2->4, 1->3->4
	 输出：1->1->2->3->4->4
 * Created by xp-zhao on 2018/12/1.
 */
public class LeetCode_21_MergeTwoSortedLists
{

	public static void main(String[] args){
		ListNode node1_1 = new ListNode(1);
		ListNode node1_2 = new ListNode(2);
		ListNode node1_3 = new ListNode(4);
		node1_1.next = node1_2;
		node1_2.next = node1_3;
		print(node1_1);
		ListNode node2_1 = new ListNode(1);
		ListNode node2_2 = new ListNode(3);
		ListNode node2_3 = new ListNode(4);
		node2_1.next = node2_2;
		node2_2.next = node2_3;
		print(node2_1);
//		ListNode node = mergeTwoLists(node1_1 , node2_1);
//		print(node);
		ListNode node1 = mergeTwoLists_loop(node1_1 , node2_1);
		print(node1);
	}

	/**
	 * 合并链表，递归
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		} else if(l2 == null){
			return l1;
		}
		ListNode result = null;
		if(l1.val < l2.val){
			result = l1;
			result.next = mergeTwoLists(l1.next,l2);
		}else{
			result = l2;
			result.next = mergeTwoLists(l1 , l2.next);
		}
		return result;
	}

	/**
	 * 合并链表，循环
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists_loop(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		} else if(l2 == null){
			return l1;
		}
		ListNode listNode = new ListNode(0);
		ListNode firstNode = listNode;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				listNode.next = l1;
				l1 = l1.next;
			}else{
				listNode.next = l2;
				l2 = l2.next;
			}
			listNode = listNode.next;
		}
		while(l1 != null){
			listNode.next = l1;
			l1 = l1.next;
			listNode = listNode.next;
		}
		while(l2 != null){
			listNode.next = l2;
			l2 = l2.next;
			listNode = listNode.next;
		}
		return firstNode.next;
	}

	public static void print(ListNode node){
		while(node.next != null){
			System.out.print(node.val+"->");
			node = node.next;
		}
		System.out.println(node.val);
	}

	static class ListNode{
		int val;
		ListNode next;

		ListNode(int x){
			val = x;
		}
	}
}
