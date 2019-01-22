package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * Created by xp-zhao on 2019/1/22.
 */
public class LeetCode_94_BinaryTreeInorderTraversal
{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = null;
		TreeNode rootRight = new TreeNode(2);
		root.right = rootRight;
		TreeNode rootRightLeft = new TreeNode(3);
		rootRight.left = rootRightLeft;
		System.out.println(root);
		System.out.println(inorderTraversal(root));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inOrder(root, result);
		return result;
	}

	public static void inOrder(TreeNode root, List<Integer> result){
		if(root == null){
			return;
		}
		inOrder(root.left, result);
		result.add(root.val);
		inOrder(root.right, result);
	}
}
