package array;

import tree.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。
 *
 * Created by xp-zhao on 2019/1/14.
 */
public class LeetCode_106_ConstructBinaryTreeFromInorderAndPostorderTraversal
{
	public static void main(String[] args) {
		int[] inorder = {9 , 3 , 15 , 20 , 7};
		int[] postorder = {9 , 15 , 7 , 20 , 3};
		System.out.println(buildTree(inorder, postorder));
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length == 1){
			return new TreeNode(inorder[0]);
		}
		int rootNum = postorder[postorder.length - 1];
		TreeNode root = new TreeNode(rootNum);
		root.left = buildTree(inorder , postorder);
		root.right = buildTree(inorder , postorder);
		return root;
	}


}
