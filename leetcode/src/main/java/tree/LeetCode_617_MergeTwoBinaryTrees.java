package tree;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * Created by xp-zhao on 2019/1/10.
 */
public class LeetCode_617_MergeTwoBinaryTrees
{
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t1Left = new TreeNode(3);
		TreeNode t1Right = new TreeNode(2);
		TreeNode t1LeftLeft = new TreeNode(5);
		t1.left = t1Left;
		t1.right = t1Right;
		t1Left.left = t1LeftLeft;
		System.out.println(t1);

		TreeNode t2 = new TreeNode(2);
		TreeNode t2Left = new TreeNode(1);
		TreeNode t2Right = new TreeNode(3);
		TreeNode t2LeftRight = new TreeNode(4);
		TreeNode t2RightRight = new TreeNode(7);
		t2.left = t2Left;
		t2.right = t2Right;
		t2Left.right = t2LeftRight;
		t2Right.right = t2RightRight;
		System.out.println(t2);
		System.out.println(mergeTrees(t1,t2));
	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null){
			return t2;
		}
		if(t2 == null){
			return t1;
		}
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left , t2.left);
		t1.right = mergeTrees(t1.right , t2.right);
		return t1;
	}
}
