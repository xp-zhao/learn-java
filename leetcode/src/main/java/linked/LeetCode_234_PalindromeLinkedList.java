package linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1: 输入: 1->2 输出: false
 * <p>
 * 示例 2: 输入: 1->2->2->1 输出: true 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ Created by xp-zhao on
 * 2019/1/7.
 */
public class LeetCode_234_PalindromeLinkedList {

  public static void main(String[] args) {
    int[] nums = {1, 2, 1};
    System.out.println(isPalindrome1(new ListNode(nums)));
    System.out.println(isPalindrome2(new ListNode(nums)));
  }

  public static boolean isPalindrome(ListNode head) {
    List<Integer> nums = new ArrayList<>();
    while (head != null) {
      nums.add(head.value);
      head = head.next;
    }
    for (int i = 0; i < nums.size() >> 1; i++) {
      if (!nums.get(i).equals(nums.get(nums.size() - i - 1))) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindrome1(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    // 找到链表的中间节点
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // 反转中间节点之后的链表
    ListNode prev = null;
    ListNode next;
    while (slow != null) {
      next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    // 比较
    while (prev != null) {
      if (prev.value != head.value) {
        return false;
      }
      prev = prev.next;
      head = head.next;
    }
    return true;
  }

  public static boolean isPalindrome2(ListNode head) {
    // 使用快慢指针定位中间位置
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) {
      // fast 不为空说明链表长度为奇数，慢指针需要再前进一步
      slow = slow.next;
    }
    ListNode left = head;
    // 从慢指针开始反转后面的链表
    ListNode right = slow.reverse();
    while (right != null) {
      if (left.value != right.value) {
        return false;
      }
      left = left.next;
      right = right.next;
    }
    return true;
  }
}
