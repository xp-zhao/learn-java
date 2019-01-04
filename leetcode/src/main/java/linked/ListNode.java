package linked;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xp-zhao on 2018/12/11.
 */
@Data
@NoArgsConstructor
public class ListNode
{
	public int      value;
	public ListNode next;

	public ListNode(int value){
		this.value = value;
	}

	public ListNode(int[] arr){
		if(arr == null || arr.length == 0){
			throw new IllegalArgumentException("arr cannot be empty");
		}
		this.value = arr[0];
		ListNode current = this;
		for(int i = 1; i < arr.length; i++)
		{
			current.next = new ListNode(arr[i]);
			current = current.next;
		}
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		ListNode current = this;
		while(current != null){
			sb.append(current.value + "->");
			current = current.next;
		}
		sb.append("null");
		return sb.toString();
	}
}
