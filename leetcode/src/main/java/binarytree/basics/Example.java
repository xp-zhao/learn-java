package binarytree.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序、中序、后序遍历
 * Created by xp-zhao on 2018/12/11.
 */
public class Example
{
	private static int num = 0;
	
	public static void main(String[] args) {
		Node node = createBinaryTree();
		List<Integer> front = new ArrayList<>();
		front(node , front);
		System.out.println("前序："+front + ", num = "+num);
		List<Integer> mid = new ArrayList<>();
		mid(node , mid);
		System.out.println("中序："+mid);
		List<Integer> end = new ArrayList<>();
		end(node , end);
		System.out.println("后序："+end);
	}

	/**
	 * 前序遍历（递归）：根节点 -> 左子树 -> 右子树
	 * @param node
	 */
	public static void front(Node node,List<Integer> list){
		num++;
		if(node == null){
			return;
		}
		list.add(node.getValue());
		front(node.getLeft(),list);
		front(node.getRight(),list);
	}

	/**
	 * 中序遍历（递归）： 左子树 -> 根节点 -> 右子树
	 * @param node
	 */
	public static void mid(Node node,List<Integer> list){
		if(node == null){
			return;
		}
		mid(node.getLeft(),list);
		list.add(node.getValue());
		mid(node.getRight() , list);
	}

	/**
	 * 后序遍历（递归）：左子树 -> 右子树 -> 根节点
	 * @param node
	 */
	public static void end(Node node,List<Integer> list){
		if(node == null){
			return;
		}
		end(node.getLeft() , list);
		end(node.getRight() , list);
		list.add(node.getValue());
	}

	/**
	 * 初始化一棵二叉树
	 * @return
	 */
	public static Node createBinaryTree(){
		Node head = new Node(1);
		Node headLeft = new Node(2);
		Node headRight = new Node(3);
		Node headLeftLeft = new Node(4);
		Node headLeftRight = new Node(5);
		Node headRightLeft = new Node(6);

		head.setLeft(headLeft);
		head.setRight(headRight);

		headLeft.setLeft(headLeftLeft);
		headLeft.setRight(headLeftRight);
		headRight.setLeft(headRightLeft);

		return head;
	}
}
