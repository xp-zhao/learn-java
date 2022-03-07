package challenge.day1;

import cn.hutool.core.collection.CollUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2022-3-7
 */
public class LeetCode83 {
  public static void main(String[] args) {
    ListNode node1 = new ListNode(2);
    ListNode node2 = new ListNode(1, node1);
    ListNode node3 = new ListNode(1, node2);
    System.out.println(deleteDuplicates(node3));
  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      if (fast.val != slow.val) {
        slow.next = fast;
        slow = slow.next;
      }
      fast = fast.next;
    }
    slow.next = null;
    return head;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      List<Integer> nums = new ArrayList<>();
      nums.add(val);
      while (next != null) {
        nums.add(next.val);
        next = next.next;
      }
      return CollUtil.join(nums, "->");
    }
  }
}
