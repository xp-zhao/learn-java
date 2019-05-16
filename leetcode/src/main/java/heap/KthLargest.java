package heap;

import java.util.PriorityQueue;

/**
 * @description: LeetCode_703: 使用 PriorityQueue 优先级队列实现
 * @author: zhaoxp
 * @create: 2019/05/16
 **/
public class KthLargest {
  private int size;
  private PriorityQueue<Integer> queue;

  public KthLargest(int k, int[] nums){
    this.size = k;
    queue = new PriorityQueue<>(k);
    for (int num : nums) {
      add(num);
    }
  }

  public int add(int val) {
    if(queue.size() < size){
      queue.add(val);
    }else if(queue.peek() < val){
      queue.poll();
      queue.add(val);
    }
    return queue.peek();
  }

  public static void main(String[] args) {
    int k = 3;
    int[] arr = {4, 5, 8, 2};
    KthLargest largest = new KthLargest(k, arr);
    System.out.println(largest.add(3));
    System.out.println(largest.add(5));
    System.out.println(largest.add(10));
    System.out.println(largest.add(9));
    System.out.println(largest.add(4));
  }
}