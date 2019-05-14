package sort;

import java.util.Arrays;

/**
 * @description: 插入排序
 *  * 1. 空间复杂度 O(1),原地排序算法
 *  * 2. 时间复杂度 O(n^2)
 *  * 3. 稳定
 * @author: zhaoxp
 * @create: 2019/05/13
 **/
public class InsertionSort {

  public static void main(String[] args) {
    int[] num = {4, 5, 6, 1, 3, 2};
    System.out.println(Arrays.toString(num));
    insertionSort(num);
    System.out.println(Arrays.toString(num));
  }

  public static void insertionSort(int[] num){
    int length = num.length;
    for (int i = 1; i < length; i++) {
      int j = i - 1;
      int value = num[i];
      // 查找插入的位置
      for(; j >= 0; j--){
        if(num[j] > value){
          num[j+1] = num[j];
        }else{
          break;
        }
      }
      num[j+1] = value;
    }
  }
}