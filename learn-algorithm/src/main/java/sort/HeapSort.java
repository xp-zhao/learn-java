package sort;

import java.util.Arrays;

/**
 * @description: 堆排序
 * @author: zhaoxp
 * @create: 2019/05/16
 **/
public class HeapSort {

  public static void main(String[] args) {
    int[] array = {7, 5, 19, 8, 4, 1, 20, 13, 16};
    System.out.println(Arrays.toString(array));
    // 建堆
    Heap heap = new Heap(array.length);
    for (int i : array) {
      heap.insert(i);
    }
    System.out.println(Arrays.toString(heap.a));
    heap.sort();
    System.out.println(Arrays.toString(heap.a));
  }

  public static class Heap {

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
      // 从下往上堆化
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

    public void sort(){
      int k = count;
      while (k > 1){
        swap(a, 1, k);
        k--;
        heapify(a, k, 1);
      }
    }

    /**
     * 从下往上堆化
     * @param array
     * @param n
     */
    private void buildHead(int[] array, int n){
      for(int i = n / 2; i >= 1; i--){
        heapify(array, n, i);
      }
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

}
