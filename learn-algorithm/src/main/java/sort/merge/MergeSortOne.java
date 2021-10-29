package sort.merge;

import java.util.Arrays;

/**
 * @author zhaoxiaoping @Description: 归并排序(1. 将数组分成两个子数组, 2. 对子数组排序, 3. 合并有序的子数组) @Date 2021-10-29
 */
public class MergeSortOne {

  public static void main(String[] args) {
    MergeSortOne mergeSort = new MergeSortOne();
    int[] arr = {1, 2, 5, 4, 3};
    System.out.println(Arrays.toString(arr));
    mergeSort.mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public void mergeSort(int[] arr) {
    if (arr.length <= 1) {
      return;
    }
    // 使用起始元素下标+末尾元素下标除以二, 元素个数是偶数时, 刚好平分
    int mid = (0 + arr.length - 1) / 2;
    int[] arr1 = Arrays.copyOfRange(arr, 0, mid + 1);
    int[] arr2 = Arrays.copyOfRange(arr, mid + 1, arr.length);
    // 对拆分的两个子数组分别进行排序
    mergeSort(arr1);
    mergeSort(arr2);
    // 对排序后的子数组进行合并
    mergeSort(arr1, arr2, arr);
  }

  private void mergeSort(int[] a1, int[] a2, int[] dest) {
    // 第一个数组的下标
    int i = 0;
    // 第二个数组的下标
    int j = 0;
    for (int pos = 0; pos < dest.length; pos++) {
      if (i == a1.length) {
        // a1 已经全部遍历完了
        dest[pos] = a2[j++];
      } else if (j == a2.length) {
        // a2 已经全部遍历完了
        dest[pos] = a1[i++];
      } else if (a1[i] <= a2[j]) {
        dest[pos] = a1[i++];
      } else {
        dest[pos] = a2[j++];
      }
    }
  }
}
