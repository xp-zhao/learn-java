package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xp-zhao on 2019/1/10.
 */
public class TreeNode
{
	int val;
	TreeNode left;
        TreeNode right;
        TreeNode(int x)
	{
		val = x;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(this);
		while(!queue.isEmpty()){
			TreeNode current = queue.remove();
			sb.append(current.val+",");
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
		}
		return sb.toString();
	}
}
