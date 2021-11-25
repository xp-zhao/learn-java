package interview.algorithm;

import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @Description: 归并排序
 * @Date
 **/
public class MergeSort {

  public static void main(String[] args) {
    MergeSort mergeSort = new MergeSort();
    int[] arr = {1, 4, 8, 6, 3, 2};
    System.out.println(Arrays.toString(arr));
    mergeSort.mergeSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  private void mergeSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    // 将数组分为两个子数组
    int mid = (left + right) / 2;
    // 对两个子数组排序
    mergeSort(arr, 0, mid);
    mergeSort(arr, mid + 1, right);
    // 合并排序后的子数组
    merge(arr, left, mid, right);
  }

  private void merge(int[] arr, int left, int mid, int right){
    // 备份原数组
    int[] temp = new int[arr.length];
    for(int pos = left; pos <= right; pos++){
      temp[pos]  = arr[pos];
    }
    // 第一个子数组开始下标
    int i = left;
    // 第二个子数组开始下标
    int j = mid + 1;
    for(int pos = left; pos <= right; pos++){
      if(i == mid + 1){
        arr[pos] = temp[j++];
      }else if(j == right + 1){
        arr[pos] = temp[i++];
      }else if(temp[i] <= temp[j]){
        arr[pos] = temp[i++];
      }else{
        arr[pos] = temp[j++];
      }
    }
  }

  private void mergeSort(int[] arr) {
    // 边界值判断
    if (null == arr || arr.length <= 1) {
      return;
    }
    // 将原数组分割成两个数组
    int mid = (0 + arr.length - 1) / 2;
    int[] arr1 = Arrays.copyOfRange(arr, 0, mid + 1);
    int[] arr2 = Arrays.copyOfRange(arr, mid + 1, arr.length);
    // 将子数组分别排序
    mergeSort(arr1);
    mergeSort(arr2);
    // 对排序好的子数组进行合并
    merge(arr1, arr2, arr);
  }

  private void merge(int[] arr1, int[] arr2, int[] dest) {
    // 第一个数组的下标
    int i = 0;
    // 第二个数组的下标
    int j = 0;
    for (int pos = 0; pos < dest.length; pos++) {
      if (i == arr1.length) {
        dest[pos] = arr2[j++];
      } else if (j == arr2.length) {
        dest[pos] = arr1[i++];
      } else if (arr1[i] <= arr2[j]) {
        dest[pos] = arr1[i++];
      } else {
        dest[pos] = arr2[j++];
      }
    }
  }
}
