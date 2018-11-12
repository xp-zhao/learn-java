package com.xp.linked.reverse;

/**
 * Created by xp-zhao on 2018/11/5.
 */
public class Node
{
	int value;
	Node next;

	public static void main(String[] args)
	{
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		node1.value = 1;
		node2.value = 2;
		node3.value = 3;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		print(node1);
		Node result = reverse(node1);
		System.out.println("");
		print(result);
	}

	public static Node reverse(Node current){
		// 保存上一个节点
		Node previous = null;
		// 保存下一个节点
		Node next;

		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public static void print(Node node)
	{
		while(node != null)
		{
			System.out.print(node.value+"->");
			node = node.next;
		}
	}
}
