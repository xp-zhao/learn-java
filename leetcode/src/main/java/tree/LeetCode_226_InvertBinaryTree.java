package tree;

/**
 * 226. 翻转二叉树
 *
 * <p>Created by xp-zhao on 2019/1/10.
 */
public class LeetCode_226_InvertBinaryTree {
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
    System.out.println(count(root));
    System.out.println(invertTree(root));
  }

  public static boolean isSameTree(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    } else if (node1 == null || node2 == null) {
      return false;
    } else if (node1.val != node2.val) {
      return false;
    }else {
      return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
  }

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = root.left;
    root.left = root.right;
    root.right = left;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  /**
   * 计算二叉树节点个数
   *
   * @param root
   * @return
   */
  public static int count(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // 当前节点+子树节点个数
    return 1 + count(root.left) + count(root.right);
  }
}
