package linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xp-zhao on 2018/12/11.
 */
@Data
@NoArgsConstructor
public class LinkedNode
{
	private int value;
	private LinkedNode next;

	public LinkedNode(int value){
		this.value = value;
	}
}
