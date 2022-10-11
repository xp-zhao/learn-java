package data_structures.linked_list;

/**
 * list 接口
 *
 * @author zhaoxiaoping
 * @date 2022-10-10
 */
public interface List<E> {
  /**
   * 添加元素
   *
   * @param e e
   * @return boolean
   */
  boolean add(E e);

  /**
   * 增加元素到头节点
   *
   * @param e e
   * @return boolean
   */
  boolean addFirst(E e);

  /**
   * 添加元素到尾结点
   *
   * @param e e
   * @return boolean
   */
  boolean addLast(E e);

  /**
   * 删除指定元素
   *
   * @param o o
   * @return boolean
   */
  boolean remove(Object o);

  /**
   * 获取指定下标的元素
   *
   * @param index 指数
   * @return {@code E}
   */
  E get(int index);

  /** 打印链表 */
  void printLinkList();
}
