package sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 *  * 1. 空间复杂度 O(1),原地排序算法
 *  * 2. 时间复杂度 O(n^2)
 *  * 3. 稳定
 * @author: zhaoxp
 * @create: 2019/05/13
 **/
public class BubbleSort {

  public static void main(String[] args) {
    int[] num = {3, 5, 4, 1, 2, 6};
    System.out.println(Arrays.toString(num));
    bubbleSort(num);
    System.out.println(Arrays.toString(num));
  }

  public static void bubbleSort(int[] array){
    int length = array.length;
    for (int i = 0; i < length; i++) {
      // 提前退出循环的标志
      boolean flag = false;
      for(int j = 0; j < length - i - 1; j++){
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          flag = true; // 有数据交换
        }
      }
      System.out.println("第 "+ (i+1) +" 次交换: "+Arrays.toString(array));
      if(!flag){
        return;
      }
    }
  }
}