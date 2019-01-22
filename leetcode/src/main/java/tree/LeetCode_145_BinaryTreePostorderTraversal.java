package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * Created by xp-zhao on 2019/1/22.
 */
public class LeetCode_145_BinaryTreePostorderTraversal
{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = null;
		TreeNode rootRight = new TreeNode(2);
		root.right = rootRight;
		TreeNode rootRightLeft = new TreeNode(3);
		rootRight.left = rootRightLeft;
		System.out.println(root);
		System.out.println(postorderTraversal(root));
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		postOrder(root, result);
		return result;
	}

	public static void postOrder(TreeNode root, List<Integer> result){
		if(root == null){
			return;
		}
		postOrder(root.left, result);
		postOrder(root.right, result);
		result.add(root.val);
	}
}
