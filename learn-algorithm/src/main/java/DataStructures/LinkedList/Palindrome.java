package DataStructures.LinkedList;

/**
 * @author zhaoxiaoping
 * @Description: 回文字符串(判断存储在单链表中的字符串是否是回文)
 * @Date 2020-10-10
 **/
public class Palindrome {

  public static void main(String[] args) {
    ListNode head = new ListNode("a");
    ListNode node1 = new ListNode("b");
    ListNode node2 = new ListNode("b");
    ListNode node3 = new ListNode("a");
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    System.out.println(isPalindrome(head));
  }

  public static boolean isPalindrome(ListNode head) {
    // 快慢指针
    ListNode slow = head;
    ListNode fast = head;
    // 记录慢指针的上一个节点
    ListNode prev = null;
    // 记录慢指针的下一个节点
    ListNode next;
    // 找到中间节点，快指针一次前进两步，慢指针一次前进一步。同时将链表前半部分逆序
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    // 快指针不为空，说明有奇数个节点，此时慢指针处于中间节点
    if (fast != null) {
      slow = slow.next;
    }
    // 比较链表的前后两部分（前半部分已逆序）
    while (slow != null) {
      if (!slow.val.equals(prev.val)) {
        return false;
      }
      slow = slow.next;
      prev = prev.next;
    }
    return true;
  }
}

class ListNode {

  String val;
  ListNode next;

  ListNode(String x) {
    val = x;
  }
}
