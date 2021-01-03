package linked;

import java.util.StringJoiner;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xp-zhao on 2018/12/11.
 */
@Data
@NoArgsConstructor
public class ListNode {

  public int value;
  public ListNode next;

  public ListNode(int value) {
    this.value = value;
  }

  public ListNode(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("arr cannot be empty");
    }
    this.value = arr[0];
    ListNode current = this;
    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }
  }

  public ListNode reverse() {
    ListNode pre = null, cur = this, next;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  @Override
  public String toString() {
    StringJoiner joiner = new StringJoiner("->");
    ListNode current = this;
    while (current != null) {
      joiner.add(String.valueOf(current.value));
      current = current.next;
    }
    return joiner.toString();
  }

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 4, 5, 6};
		ListNode head = new ListNode(array);
		System.out.println(head);
	}
}
