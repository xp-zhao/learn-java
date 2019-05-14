package sort;

import java.util.Arrays;

/**
 * @description: 选择排序
 * 1. 空间复杂度 O(1),原地排序算法
 * 2. 时间复杂度 O(n^2)
 * 3. 不稳定
 * @author: zhaoxp
 * @create: 2019/05/13
 **/
public class SelectionSort {

  public static void main(String[] args) {
    int[] num = {4, 5, 6, 3, 2, 1};
    System.out.println(Arrays.toString(num));
    selectionSort(num);
    System.out.println(Arrays.toString(num));
  }

  public static void selectionSort(int[] num){
    int length = num.length;
    for (int i = 0; i < length; i++) {
      int min = i;
      // 找到最小元素的下标
      for(int j = i + 1; j < length; j++){
        if(num[j] < num[min]){
          min = j;
        }
      }
      int temp = num[i];
      num[i] = num[min];
      num[min] = temp;
    }
  }
}