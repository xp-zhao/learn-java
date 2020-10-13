package sort;

import java.util.Arrays;

/**
 * 归并排序 Created by xp-zhao on 2018/9/13.
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] arr = {5, 3, 1, 7, 4, 9, 2};
    System.out.println(Arrays.toString(mergeSort(arr)));
  }

  public static int[] mergeSort(int[] arr) {
    if (arr == null) {
      return new int[0];
    }
    if (arr.length == 1) {
      return arr;
    }
    int mid = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, mid);
    int[] right = Arrays.copyOfRange(arr, mid, arr.length);
    left = mergeSort(left);
    right = mergeSort(right);
    return mergeArrays(left, right);
  }

  public static int[] mergeArrays(int[] a, int[] b) {
    if (a == null) {
      return new int[0];
    }
    if (b == null) {
      return new int[0];
    }
    int[] merged = new int[a.length + b.length];
    int ai = 0, bi = 0, mi = 0;
    while (ai < a.length && bi < b.length) {
      if (a[ai] < b[bi]) {
        merged[mi] = a[ai];
        ai++;
      } else {
        merged[mi] = b[bi];
        bi++;
      }
      mi++;
    }
    while (ai < a.length) {
      merged[mi++] = a[ai++];
    }
    while (bi < b.length) {
      merged[mi++] = b[bi++];
    }
    return merged;
  }
}
