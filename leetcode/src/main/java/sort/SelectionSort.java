package sort;

import java.util.Arrays;

/**
 * 选择排序 Created by xp-zhao on 2018/9/13.
 */
public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = {1, 5, 3, 7, 4, 9, 2};
//    int min, temp;
//    for (int i = 0; i < arr.length - 1; i++) {
//      min = i;
//      for (int j = i + 1; j < arr.length; j++) {
//        if (arr[j] < arr[min]) {
//          min = j;
//        }
//      }
//      if (min != i) {
//        temp = arr[i];
//        arr[i] = arr[min];
//        arr[min] = temp;
//      }
//    }
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void selectionSort(int[] arr) {
    int minIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[i]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
      }
    }
  }
}
