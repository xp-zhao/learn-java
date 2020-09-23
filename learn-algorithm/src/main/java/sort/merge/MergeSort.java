package sort.merge;

import java.util.Arrays;

/**
 * @description: 归并排序
 * 1. 空间复杂度 O(n)，不是原地排序算法
 * 2. 时间复杂度 O(nlogn)
 * 3. 稳定
 * @author: zhaoxp
 * @create: 2019/05/13
 **/
public class MergeSort {

  public static void main(String[] args) {
    int[] num = {11, 8, 3, 9, 7, 1, 2, 5};
    System.out.println(Arrays.toString(num));
    mergeSort(num);
    System.out.println(Arrays.toString(num));
  }

  public static void mergeSort(int[] num) {
    int length = num.length;
    sort(num, 0, length - 1);
  }

  public static void sort(int[] array, int left, int right) {
    if (left >= right) {
      // 递归终止条件
      return;
    }
    // 取中间位置，将数组分为两半
    int mid = left + (right - left) / 2;
    // 分治递归
    sort(array, left, mid);
    sort(array, mid + 1, right);
    // 合并两个有序数组
    merge(array, left, mid, right);
  }

  public static void merge(int[] array, int left, int mid, int right) {
    int i = left;
    int j = mid + 1;
    int k = 0;
    int[] temp = new int[right - left + 1];
    while (i <= mid && j <= right) {
      if (array[i] <= array[j]) {
        temp[k++] = array[i++];
      } else {
        temp[k++] = array[j++];
      }
    }
    int start = i;
    int end = mid;
    if (j <= right) {
      start = j;
      end = right;
    }

    while (start <= end) {
      temp[k++] = array[start++];
    }

    for (i = 0; i <= right - left; i++) {
      array[left + i] = temp[i];
    }
  }
}