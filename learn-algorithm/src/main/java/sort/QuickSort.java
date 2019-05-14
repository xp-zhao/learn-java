package sort;

import java.util.Arrays;

/**
 * @description: 快速排序
 * 1. 空间复杂度 O(1), 原地排序算法
 * 2. 时间复杂度 O(nlogn)，极端情况下会退化到 O(n^2）
 * 3. 不稳定
 * @author: zhaoxp
 * @create: 2019/05/14
 **/
public class QuickSort {

  public static void main(String[] args) {
//    int[] arr = {5, 3, 1, 7, 4, 9, 2};
    int[] arr = {4, 2, 5, 12, 3};
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = partition_right(array, left, right);
    sort(array, left, mid - 1);
    sort(array, mid + 1, right);
  }

  private static int partition_right(int[] array, int left, int right) {
    int pivot = array[right];
    int index = left;
    for (int j = left; j <= right - 1; j++) {
      if (array[j] < pivot) {
        swap(array, index, j);
        index++;
      }
    }
    swap(array, index, right);
    return index;
  }

  private static int partition_left(int[] array, int left, int right) {
    int pivot = array[left];
    int index = right;
    for (int j = right; j >= left + 1; j--) {
      if (array[j] > pivot) {
        swap(array, index, j);
        index--;
      }
    }
    swap(array, index, left);
    return index;
  }

  private static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}