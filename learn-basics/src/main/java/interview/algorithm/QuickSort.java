package interview.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 7, 6, 4, 2};
    System.out.println(Arrays.toString(arr));
    QuickSort quickSort = new QuickSort();
    quickSort.quickSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int left, int right) {
    // 边界值判断
    if (left >= right) {
      return;
    }
    // 1. 选取一个基准点, 将数组分成两部分, 左边都不大于基准点, 右边都不小于基准点, 并返回基准点下标
    int mid = partition(arr, left, right);
    // 2. 按照相同的算法对左边的数组进行排序
    quickSort(arr, 0, mid - 1);
    // 3. 按照相同的算法对右边的数组进行排序
    quickSort(arr, mid + 1, right);
  }

  private int partition(int[] arr, int left, int right) {
    // 选取数组第一个元素为基准点
    int pivot = arr[left];
    // 数组最后一个元素的下标
    int j = right;
    for (int i = left + 1; i <= j; ) {
      if (arr[i] > pivot) {
        swap(arr, i, j);
        j--;
      } else {
        i++;
      }
    }
    swap(arr, left, j);
    return j;
  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
