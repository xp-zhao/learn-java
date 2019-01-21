package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xp-zhao on 2019/1/10.
 */
public class LeetCode_965_UnivaluedBinaryTree
{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode rootLeft = new TreeNode(1);
		TreeNode rootRight = new TreeNode(1);
		TreeNode rootLeftLeft = new TreeNode(1);
		TreeNode rootLeftRight = new TreeNode(1);
		TreeNode rootRightLeft = new TreeNode(1);
		TreeNode rootRightRight = new TreeNode(1);
		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = rootLeftLeft;
		rootLeft.right = rootLeftRight;
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
		System.out.println(root);
		System.out.println(isUnivalTree(root));
	}

	public static boolean isUnivalTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int temp = root.val;
		while(!queue.isEmpty()){
			TreeNode current = queue.remove();
			if(current.val != temp){
				return false;
			}
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
		}
		return true;
	}
}
