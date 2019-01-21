package tree;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。
 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

	     3
	  /   \
	 9  20
	 /  \
	 15   7
 返回它的最大深度 3 。
 * Created by xp-zhao on 2019/1/10.
 */
public class LeetCode_104_MaximumDepthOfBinaryTree
{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode rootLeft = new TreeNode(9);
		TreeNode rootRight = new TreeNode(20);
		TreeNode rootRightLeft = new TreeNode(15);
		TreeNode rootRightRight = new TreeNode(7);
		root.left = rootLeft;
		root.right = rootRight;
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
		System.out.println(root);
		System.out.println(maxDepth(root));
	}

	public static int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}else{
			int leftDepth = maxDepth(root.left);
			int rightDepth = maxDepth(root.right);
			return Math.max(leftDepth , rightDepth) + 1;
		}
	}
}
