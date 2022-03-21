package LRU;

/**
 * 双向链表
 *
 * @author zhaoxiaoping
 * @date 2022-3-21
 */
public class DoubleList {

  /** 头虚节点 */
  private Node head;
  /** 尾虚节点 */
  private Node tail;
  /** 链表元素数 */
  private int size;

  public DoubleList() {
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  /**
   * 在链表尾部添加节点 x
   *
   * @param x x
   */
  public void addLast(Node x) {
    x.prev = tail.prev;
    x.next = tail;
    tail.prev.next = x;
    tail.prev = x;
    size++;
  }

  /**
   * 删除链表中的 x 接口
   *
   * @param x x
   */
  public void remove(Node x) {
    x.prev.next = x.next;
    x.next.prev = x.prev;
    size--;
  }

  /**
   * 删除链表的第一个节点，并返回该节点
   *
   * @return {@code Node}
   */
  public Node removeFirst() {
    if (head.next == tail) {
      return null;
    }
    Node first = head.next;
    remove(first);
    return first;
  }

  public int size() {
    return size;
  }
}
