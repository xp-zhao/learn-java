package tree;

/**
 * 226. 翻转二叉树
 *
 * Created by xp-zhao on 2019/1/10.
 */
public class LeetCode_226_InvertBinaryTree
{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode rootLeft = new TreeNode(2);
		TreeNode rootRight = new TreeNode(7);
		TreeNode rootLeftLeft = new TreeNode(1);
		TreeNode rootLeftRight = new TreeNode(3);
		TreeNode rootRightLeft = new TreeNode(6);
		TreeNode rootRightRight = new TreeNode(9);
		root.left = rootLeft;
		root.right = rootRight;
		rootLeft.left = rootLeftLeft;
		rootLeft.right = rootLeftRight;
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
		System.out.println(root);
		System.out.println(invertTree(root));
	}

	public static TreeNode invertTree(TreeNode root) {
		if(root == null){
			return null;
		}
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		if(root.left != null){
			invertTree(root.left);
		}
		if(root.right != null){
			invertTree(root.right);
		}
		return root;
	}
}