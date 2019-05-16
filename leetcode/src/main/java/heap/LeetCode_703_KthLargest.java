package heap;

/**
 * @description: 数据流中第 K 大的元素 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。 你的 KthLargest
 * 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3; int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 * 说明: 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * @author: zhaoxp
 * @create: 2019/05/16
 **/
public class LeetCode_703_KthLargest {

  int[] heap;
  int index;

  public LeetCode_703_KthLargest(int k, int[] nums) {
    heap = new int[k + 1];
    for (int num : nums) {
      add(num);
    }
  }

  public static void main(String[] args) {
    int k = 7;
    int[] arr = {-10,1,3,1,4,10,3,9,4,5,1};
    LeetCode_703_KthLargest largest = new LeetCode_703_KthLargest(k, arr);
    System.out.println(largest.add(3));
    System.out.println(largest.add(2));
    System.out.println(largest.add(3));
    System.out.println(largest.add(1));
    System.out.println(largest.add(2));
    System.out.println(largest.add(4));
  }

  public int add(int val) {
    if (index >= heap.length - 1) {
      // 堆满了
      if (val <= heap[1]) {
        return heap[1];
      } else {
        removeMin();
        index++;
        heap[index] = val;
      }
    } else {
      index++;
      heap[index] = val;
    }
    int i = index;
    // 从下往上堆化
    while (i / 2 > 0 && heap[i] < heap[i / 2]) {
      swap(heap, i, i / 2);
      i = i / 2;
    }
    return heap[1];
  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  // 堆化，从上往下
  private void heapify(int[] a, int count, int i){
    while (true){
      int minPos = i;
      if(i * 2 <= count && a[i] > a[i * 2]){
        minPos = i * 2;
      }
      if(i * 2 + 1 <= count && a[minPos] > a[i * 2 + 1]){
        minPos = i * 2 + 1;
      }
      if(minPos == i){
        break;
      }
      swap(a, i, minPos);
      i = minPos;
    }
  }

  private void removeMin(){
    heap[1] = heap[index];
    index--;
    heapify(heap, index, 1);
  }
}