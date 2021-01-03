package linked;

/**
 * 链表反转 Created by xp-zhao on 2018/12/11.
 */
public class LeetCode_206_LinkedReversal {

  public static ListNode successor = null;

  public static void main(String[] args) {
    ListNode node = new ListNode(new int[]{1, 2, 3, 4, 5, 6});
    System.out.println(node);
    System.out.println(node.reverse());
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

  public static void traverse(ListNode head) {
    // 链表后序遍历
    if (head == null) {
      return;
    }
    traverse(head.next);
    System.out.println(head.value);
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
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  public static ListNode reverse(ListNode a, ListNode b) {
    ListNode pre = null;
    ListNode current = a;
    ListNode next;
    while (current != b) {
      next = current.next;
      current.next = pre;
      pre = current;
      current = next;
    }
    return pre;
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

  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode a, b;
    a = b = head;
    for (int i = 0; i < k; i++) {
      if (b == null) {
        return head;
      }
      b = b.next;
    }
    ListNode newHead = reverse(a, b);
    a.next = reverseKGroup(b, k);
    return newHead;
  }
}
