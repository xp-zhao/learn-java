package Heap;

/**
 * @description: 堆
 * @author: zhaoxp
 * @create: 2019/05/15
 **/
public class Heap {

  private int[] a; // 数组，从下标 1 开始存储数据
  private int n; // 堆可以存储的最大数据个数
  private int count; // 堆中已经存储的数据个数

  public Heap(int capacity) {
    a = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public void insert(int data) {
    if (count >= n) {
      return; // 堆满了
    }
    count++;
    a[count] = data;
    int i = count;
    while (i / 2 > 0 && a[i] > a[i / 2]) {
      swap(a, i, i / 2);
      i = i / 2;
    }
  }

  public void removeMax() {
    if (count == 0) {
      return; // 堆中没有数据
    }
    a[1] = a[count]; // 将最后一个数据放到堆顶
    --count;
    heapify(a, count, 1); // 堆化
  }

  private void heapify(int[] a, int count, int i) {
    while (true) {
      int maxPos = i;
      if (i * 2 <= count && a[i] < a[i * 2]) {
        maxPos = i * 2;
      }
      if (i * 2 + 1 <= count && a[maxPos] < a[i * 2 + 1]) {
        maxPos = i * 2 + 1;
      }
      if (maxPos == i) {
        break;
      }
      swap(a, i, maxPos);
      i = maxPos;
    }
  }

  private void swap(int[] a, int i, int i1) {
    int tmp = a[i];
    a[i] = a[i1];
    a[i1] = tmp;
  }
}