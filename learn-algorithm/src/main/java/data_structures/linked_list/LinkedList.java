package data_structures.linked_list;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import java.util.StringJoiner;

/**
 * @author zhaoxiaoping
 * @date 2022-10-10
 */
public class LinkedList<E> implements List<E> {

  transient int size = 0;
  transient Node<E> first;
  transient Node<E> last;

  public LinkedList() {}

  void linkedFirst(E e) {
    final Node<E> f = first;
    final Node<E> newNode = new Node<>(null, e, f);
    first = newNode;
    if (f == null) {
      last = newNode;
    } else {
      f.prev = newNode;
    }
    size++;
  }

  void linkedLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null) {
      first = newNode;
    } else {
      l.next = newNode;
    }
    size++;
  }

  E unlink(Node<E> x) {
    final E e = x.item;
    final Node<E> prev = x.prev;
    final Node<E> next = x.next;

    if (prev == null) {
      first = next;
    } else {
      prev.next = next;
      x.prev = null;
    }
    if (next == null) {
      last = prev;
    } else {
      next.prev = prev;
      x.next = null;
    }
    x.item = null;
    size--;
    return e;
  }

  Node<E> node(int index) {
    if (index < (size >> 1)) {
      Node<E> x = first;
      for (int i = 0; i < index; i++) {
        x = x.next;
      }
      return x;
    } else {
      Node<E> x = last;
      for (int i = size - 1; i > index; i--) {
        x = x.prev;
      }
      return x;
    }
  }

  @Override
  public boolean add(E e) {
    linkedLast(e);
    return true;
  }

  @Override
  public boolean addFirst(E e) {
    linkedFirst(e);
    return true;
  }

  @Override
  public boolean addLast(E e) {
    linkedLast(e);
    return true;
  }

  @Override
  public boolean remove(Object o) {
    if (o == null) {
      for (Node<E> x = first; x != null; x = x.next) {
        if (x.item == null) {
          unlink(x);
          return true;
        }
      }
    } else {
      for (Node<E> x = first; x != null; x = x.next) {
        if (o.equals(x.item)) {
          unlink(x);
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public E get(int index) {
    return node(index).item;
  }

  @Override
  public void printLinkList() {
    if (this.size == 0) {
      System.out.println("链表为空");
    } else {
      Node<E> temp = first;
      System.out.print("目前的列表，头节点：" + first.item + " 尾节点：" + last.item + " 整体：");
      StringJoiner sj = new StringJoiner(StrUtil.COMMA);
      while (temp != null) {
        sj.add(Convert.toStr(temp.item));
        temp = temp.next;
      }
      System.out.println(sj.toString());
      System.out.println();
    }
  }

  private static class Node<E> {
    E item;
    Node<E> prev;
    Node<E> next;

    public Node(Node<E> prev, E item, Node<E> next) {
      this.item = item;
      this.prev = prev;
      this.next = next;
    }
  }
}
