package TopN;

import java.util.Arrays;

/**
 * MinHeap.java 小顶堆解决 TopN 问题
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/20
 **/
public class MinHeap {

  public static void main(String[] args) {
    int[] nums = {56, 30, 71, 18, 29, 93, 44, 75, 20, 65, 68, 34};
    // 最大的五个元素：[68, 65, 71, 75, 93]
    Heap heap = new Heap(5);
    for (int num : nums) {
      heap.insert(num);
    }
    System.out.println(Arrays.toString(heap.arr));
  }

  /**
   * 小顶堆
   */
  static class Heap {

    private int[] arr;
    private int n;
    private int count;

    public Heap(int capacity) {
      arr = new int[capacity + 1];
      n = capacity;
      count = 0;
    }

    private void insert(int data) {
      if (count < n) {
        count++;
        arr[count] = data;
        int i = count;
        // 从下往上堆化(小顶堆)
        while (i / 2 > 0 && arr[i] < arr[i / 2]) {
          swap(arr, i, i / 2);
          i = i / 2;
        }
        return;
      }
      // 小于堆顶元素，直接丢弃
      if (data < arr[1]) {
        return;
      } else {
        // 替换堆顶元素
        arr[1] = data;
        // 堆化
        heapity(arr, count, 1);
      }
    }

    /**
     * 将数组构造成小顶堆
     */
    private void buildHeap(int[] array) {

    }

    /**
     * 堆化(从上往下堆化)
     */
    private void heapity(int[] array, int n, int i) {
      while (true) {
        int minPos = i;
        if (i * 2 <= n && array[i] > array[i * 2]) {
          minPos = i * 2;
        }
        if (i * 2 + 1 <= n && array[minPos] > array[i * 2 + 1]) {
          minPos = i * 2 + 1;
        }
        if (minPos == i) {
          return;
        }
        swap(array, i, minPos);
        i = minPos;
      }
    }

    /**
     * 删除堆顶最小元素
     */
    private void removeMin(){
      if(count == 0){
        return;
      }
      // 将最后一个元素移动到堆顶
      arr[1] = arr[count];
      count--;
      // 进行堆化
      heapity(arr, count, 1);
    }

    /**
     * 交换位置
     */
    private void swap(int[] array, int i, int j) {
      int tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
    }
  }
}