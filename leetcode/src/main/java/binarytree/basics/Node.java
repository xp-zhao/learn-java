package binarytree.basics;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xp-zhao on 2018/12/11.
 */
@Data
@NoArgsConstructor
public class Node
{
	private int value;
	private Node left;
	private Node right;

	public Node(int value){
		this.value = value;
	}
}
