package data_structures.array_list;

import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @date 2022-10-11
 */
public class ArrayList<E> implements List<E> {

  /** 默认初始化空间 */
  private static final int DEFAULT_CAPACITY = 10;

  /** 空元素 */
  private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

  /** ArrayList 元素数组缓存区 */
  transient Object[] elementData;

  /** List 集合元素数量 */
  private int size;

  public ArrayList() {
    /** 初始化时默认是空元素 */
    this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
  }

  @Override
  public boolean add(E e) {
    // 确保内部容量
    int minCapacity = size + 1;
    if (elementData == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
      minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    // 判断扩容操作
    if (minCapacity - elementData.length > 0) {
      int oldCapacity = elementData.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      if (newCapacity - minCapacity < 0) {
        newCapacity = minCapacity;
      }
      elementData = Arrays.copyOf(elementData, newCapacity);
    }
    elementData[size++] = e;
    return true;
  }

  @Override
  public E remove(int index) {
    E oldValue = (E) elementData[index];
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      // 从原始数组的某个位置，拷贝到目标对象的某个位置开始后n个元素
      System.arraycopy(elementData, index + 1, elementData, index, numMoved);
    }
    elementData[--size] = null;
    return oldValue;
  }

  @Override
  public E get(int index) {
    return (E) elementData[index];
  }

  @Override
  public String toString() {
    return "ArrayList{" + "elementData=" + Arrays.toString(elementData) + ", size=" + size + '}';
  }
}
