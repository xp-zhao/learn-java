package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by xp-zhao on 2019/1/9.
 */
public class BST<E extends Comparable<E>>
{
	private class Node{
		public E e;
		public Node left;
		private Node right;

		public Node(E e){
			this.e = e;
			left = null;
			right = null;
		}
	}

	private Node root;
	private int size;

	public BST(){
		root = null;
		size = 0;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * 向二分搜索树添加新元素 e
	 * @param e
	 */
	public void add(E e){
//		if(root == null){
//			root = new Node(e);
//			size++;
//		}else{
//			add(root, e);
//		}
		root = add(root , e);
	}

	/**
	 * 向以 node 为根节点的二分搜索树中插入元素 e，递归
	 * @param node
	 * @param e
	 */
	private void add1(Node node, E e){
		if(e.equals(node.e)){
			return;
		}else if(e.compareTo(node.e) < 0 && node.left == null){
			node.left = new Node(e);
			size++;
			return;
		}else if(e.compareTo(node.e) > 0 && node.right == null){
			node.right = new Node(e);
			size++;
			return;
		}
		if(e.compareTo(node.e) < 0){
			add1(node.left, e);
		}else{
			add1(node.right , e);
		}
	}

	/**
	 * 向以 node 为根节点的二分搜索树中插入元素 e，递归
	 * 返回插入新节点后二分搜索树的根
	 * @param node
	 * @param e
	 */
	private Node add(Node node, E e){
		if(node == null){
			size++;
			return new Node(e);
		}
		if(e.compareTo(node.e) < 0){
			node.left = add(node.left, e);
		}else if(e.compareTo(node.e) > 0){
			node.right = add(node.right , e);
		}
		return node;
	}

	/**
	 * 看二分搜索树中是否包含元素 e，递归
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		return contains(root , e);
	}

	/**
	 * 查询以 node 为根的二分搜索树中是否包含元素 e
	 * @param node
	 * @param e
	 * @return
	 */
	private boolean contains(Node node, E e){
		if(node == null){
			return false;
		}
		if(e.compareTo(node.e) == 0){
			return true;
		}else if(e.compareTo(node.e) < 0){
			return contains(node.left, e);
		}else{
			return contains(node.right, e);
		}
	}

	/**
	 * 二分搜索树前序遍历,非递归
	 */
	public void preOrderNR(){
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node current = stack.pop();
			System.out.println(current.e);
			if(current.right != null){
				stack.push(current.right);
			}
			if(current.left != null){
				stack.push(current.left);
			}
		}
	}

	/**
	 * 二分搜索树前序遍历
	 */
	public void preOrder(){
		preOrder(root);
	}

	/**
	 * 前序遍历以 node 为根节点的二分搜索树
	 * @param node
	 */
	private void preOrder(Node node){
		if(node == null){
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}

	/**
	 *二分搜索树中序遍历
	 */
	public void inOrder(){
		inOrder(root);
	}

	/**
	 * 中序遍历以 node 为根节点的二分搜索树
	 * @param node
	 */
	private void inOrder(Node node){
		if(node == null){
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	/**
	 *二分搜索树后序遍历
	 */
	public void postOrder(){
		postOrder(root);
	}

	/**
	 * 后序遍历以 node 为根节点的二分搜索树
	 * @param node
	 */
	private void postOrder(Node node){
		if(node == null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	public void levelOrder(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node current = queue.remove();
			System.out.println(current.e);
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
		}
	}

	/**
	 * 寻找二分搜索数的最小元素
	 * @return
	 */
	public E minimum(){
		if(size == 0){
			throw new IllegalArgumentException("BST is empty!");
		}
		return minimum(root).e;
	}

	/**
	 * 返回以 node 为根节点的二分搜索树的最小值所在的节点
	 * @param node
	 * @return
	 */
	private Node minimum(Node node){
		if(node.left == null){
			return node;
		}
		return minimum(node.left);
	}

	/**
	 * 寻找二分搜索数的最大元素
	 * @return
	 */
	public E maximum(){
		if(size == 0){
			throw new IllegalArgumentException("BST is empty!");
		}
		return maximum(root).e;
	}

	/**
	 * 返回以 node 为根节点的二分搜索树的最大值所在的节点
	 * @param node
	 * @return
	 */
	private Node maximum(Node node){
		if(node.right == null){
			return node;
		}
		return maximum(node.right);
	}

	/**
	 * 从二分搜索树中删除最小值所在节点，返回最小值
	 * @return
	 */
	public E removeMin(){
		E result = minimum();
		root = removeMin(root);
		return result;
	}

	/**
	 * 删除以 node 为根的二分搜索树中的最小节点
	 * 返回删除节点后新的二分搜索树的根
	 * @param node
	 * @return
	 */
	private Node removeMin(Node node){
		if(node.left == null){
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	/**
	 * 从二分搜索树中删除最大值所在节点，返回最大值
	 * @return
	 */
	public E removeMax(){
		E result = maximum();
		root = removeMax(root);
		return result;
	}

	/**
	 * 删除以 node 为根的二分搜索树中的最小节点
	 * 返回删除节点后新的二分搜索树的根
	 * @param node
	 * @return
	 */
	private Node removeMax(Node node){
		if(node.right == null){
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}

	/**
	 * 从二分搜索树中删除元素为 e 的节点
	 * @param e
	 */
	public void remove(E e){
		root = remove(root, e);
	}

	/**
	 * 删除以 node 为根节点的二分搜索树中值为 e 的节点，递归
	 * 返回删除节点后新的二分搜索树的根
	 * @param node
	 * @param e
	 * @return
	 */
	private Node remove(Node node, E e){
		if(node == null){
			return null;
		}
		if(e.compareTo(node.e) < 0){
			node.left = remove(node.left, e);
		}else if(e.compareTo(node.e) > 0){
			node.right = remove(node.right, e);
		}else{
			// 待删除节点左子树为空的情况
			if(node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			// 待删除节点右子树为空的情况
			if(node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			// 待删除节点左右子树均不为空的情况
			// 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
			// 用这个节点顶替待删除节点的位置
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left = node.right = null;
			return successor;
		}
		return node;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		generateBSTString(root , 0 , sb);
		return sb.toString();
	}

	/**
	 * 以 node 为根节点，深度为 depth 的描述二叉树的字符串
	 * @param node
	 * @param depth
	 * @param sb
	 */
	private void generateBSTString(Node node, int depth, StringBuilder sb){
		if(node == null){
			sb.append(generateDepthString(depth) + "null\n");
			return;
		}
		sb.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left , depth + 1 , sb);
		generateBSTString(node.right , depth + 1 , sb);
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
