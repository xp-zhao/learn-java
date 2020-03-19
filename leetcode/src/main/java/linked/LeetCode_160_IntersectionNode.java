package linked;

/**
 * LeetCode_160_IntersectionNode.java
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 相交链表
 *
 * @author: zhaoxiaoping
 * @date: 2019/12/31
 **/
public class LeetCode_160_IntersectionNode {

  public static void main(String[] args) {
    ListNode headA = new ListNode(new int[]{4, 1, 8, 4, 5});
    ListNode headB = new ListNode(new int[]{5, 0, 1, 8, 4, 5});
    System.out.println(headA);
    System.out.println(headB);
    System.out.println(getIntersectionNode(headA, headB));
  }

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode curA = headA;
    ListNode curB = headB;
    while (curA != null && curB != null) {

    }
    return null;
  }
}