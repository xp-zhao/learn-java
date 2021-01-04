package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/** Created by xp-zhao on 2019/1/10. */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    StringJoiner joiner = new StringJoiner(",");
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(this);
    while (!queue.isEmpty()) {
      TreeNode current = queue.remove();
      joiner.add(String.valueOf(current.val));
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    return joiner.toString();
  }
}
