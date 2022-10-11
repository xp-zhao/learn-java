package data_structures.linked_list.test;

import data_structures.linked_list.LinkedList;
import data_structures.linked_list.List;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-10-11
 */
public class LinkedListTest {
  public static void main(String[] args) {
    List<String> list = new LinkedList<>();
    list.add("a");
    list.addFirst("b");
    list.addLast("c");
    list.printLinkList();
    list.addFirst("d");
    list.remove("b");
    list.printLinkList();
  }
}
