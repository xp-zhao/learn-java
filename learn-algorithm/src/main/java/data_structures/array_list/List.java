package data_structures.array_list;

/**
 * list 接口
 *
 * @author zhaoxiaoping
 * @date 2022-10-11
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
   * 删除指定下标的元素
   *
   * @param index 下标
   * @return {@code E}
   */
  E remove(int index);

  /**
   * 获取指定下标的元素
   *
   * @param index 下标
   * @return {@code E}
   */
  E get(int index);
}
