package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * Created by xp-zhao on 2019/1/22.
 */
public class LeetCode_144_BinaryTreePreorderTraversal
{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = null;
		TreeNode rootRight = new TreeNode(2);
		root.right = rootRight;
		TreeNode rootRightLeft = new TreeNode(3);
		rootRight.left = rootRightLeft;
		System.out.println(root);
		System.out.println(preorderTraversal(root));
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		preOrder(root, result);
		return result;
	}

	public static void preOrder(TreeNode root, List<Integer> result){
		if(root == null){
			return;
		}
		result.add(root.val);
		preOrder(root.left, result);
		preOrder(root.right, result);
	}
}
