package linked;

/**
 * @description: 删除链表的倒数第 N 个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * @author: zhaoxp
 * @create: 2019/05/13
 **/
public class LeetCode_19_RemoveNthFromEnd {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    ListNode node = new ListNode(array);
    System.out.println(node.toString());
    System.out.println(removeNthFromEnd(node, 2));
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode node = head;
    ListNode result = head;
    while (head != null) {
      count++;
      head = head.next;
    }
    if(n == count){
      return node.next;
    }
    while (node != null){
      count--;
      if(count == n){
        node.next = node.next.next;
        return result;
      }
      node = node.next;
    }
    return null;
  }
}