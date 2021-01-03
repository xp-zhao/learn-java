package linked;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 链表反转 Created by xp-zhao on 2018/12/11.
 */
public class LeetCode_206_LinkedReversal {

  public static ListNode successor = null;

  public static void main(String[] args) {
    ListNode node = createLinked();
    printLinked(node);
    ListNode result = reverse3(node);
    printLinked(result);
    ListNode result1 = reverse3(result);
    printLinked(result1);
    ListNode result2 = reverse4(result1);
    printLinked(result2);
    ListNode result3 = reverseN(result2, 2);
    printLinked(result3);
    printLinked(reverseBetween(result3, 2, 3));
  }

  public static ListNode reverse4(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode last = reverse4(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }

  public static ListNode reverseN(ListNode head, int n) {
    if (n == 1) {
      successor = head.next;
      return head;
    }
    ListNode last = reverseN(head.next, n - 1);
    head.next.next = head;
    head.next = successor;
    return last;
  }

  public static ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == 1) {
      return reverseN(head, n);
    }
    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
  }

  public static ListNode reverse(ListNode current) {
    ListNode previous = null;
    ListNode next;
    while (current != null) {
      next = current.getNext();
      current.setNext(previous);
      previous = current;
      current = next;
    }
    return previous;
  }

  public static ListNode reverse1(ListNode head) {
    ListNode pre = null;
    ListNode current;
    while (head != null) {
      current = head;
      head = head.next;
      current.next = pre;
      pre = current;
    }
    return pre;
  }

  public static ListNode reverse3(ListNode head) {
    // 上一个节点
    ListNode prev = null;
    // 下一个节点
    ListNode next;
    // 反转链表
    while (head != null) {
      // 保留下一个节点
      next = head.next;
      // 将当前节点的 next 指针指向上一个节点
      head.next = prev;
      // 当前节点变为上一个节点
      prev = head;
      // 当前节点往后移
      head = next;
    }
    return prev;
  }

  public static ListNode createLinked() {
    ListNode head = new ListNode(1);
    ListNode next = new ListNode(2);
    ListNode nextNext = new ListNode(3);
    head.setNext(next);
    next.setNext(nextNext);
    return head;
  }


  public static void printLinked(ListNode node) {
    List<Integer> list = new ArrayList<>();
    while (node != null) {
      list.add(node.getValue());
      node = node.getNext();
    }
    System.out.println(StringUtils.join(list.toArray(), "->"));
  }
}
