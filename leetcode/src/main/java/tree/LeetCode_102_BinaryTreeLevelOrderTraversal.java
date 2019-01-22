package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * Created by xp-zhao on 2019/1/22.
 */
public class LeetCode_102_BinaryTreeLevelOrderTraversal
{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode rootLeft = new TreeNode(9);
		root.left = rootLeft;
		TreeNode rootRight = new TreeNode(20);
		root.right = rootRight;
		TreeNode rootRightLeft = new TreeNode(15);
		TreeNode rootRightRight = new TreeNode(7);
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
		System.out.println(root);
		System.out.println(levelOrder1(root));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null){
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int count = queue.size();
			List<Integer> node = new ArrayList<>();
			while(count > 0){
				TreeNode current = queue.remove();
				node.add(current.val);
				if(current.left != null){
					queue.add(current.left);
				}
				if(current.right != null){
					queue.add(current.right);
				}
				count--;
			}
			result.add(node);
		}
		return result;
	}

	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		addList(result, 0, root);
		return result;
	}

	public static void addList(List<List<Integer>> result, int level, TreeNode root){
		if(root == null){
			return;
		}
		if(result.size() - 1 < level){
			result.add(new ArrayList<>());
		}
		result.get(level).add(root.val);
		addList(result, level + 1, root.left);
		addList(result, level + 1, root.right);
	}
}
