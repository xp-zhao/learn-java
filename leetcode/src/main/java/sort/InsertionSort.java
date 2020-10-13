package sort;

import java.util.Arrays;

/**
 * 插入排序 Created by xp-zhao on 2018/9/13.
 */
public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = {5, 3, 1, 7, 4, 9, 2};
    insertionSort(arr);
//    int temp, j;
//    for (int i = 1; i < arr.length; i++) {
//      j = i - 1;
//      temp = arr[i];
//      while (j >= 0 && arr[j] > temp) {
//        arr[j + 1] = arr[j];
//        j--;
//      }
//      arr[j + 1] = temp;
//    }
    System.out.println(Arrays.toString(arr));
  }

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int j = i - 1;
      int value = arr[i];
      while (j >= 0 && arr[j] > value) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = value;
    }
  }
}
