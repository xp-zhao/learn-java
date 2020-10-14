package array;

import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @Description: 求无序数组中第 K 大的元素
 * @Date 2020-10-14
 **/
public class KthSmallest {

  public static void main(String[] args) {
    int[] arr = {4, 2, 5, 12, 3};
    partition(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
    int[] arr1 = {4, 2, 5, 12, 3};
    partition1(arr1, 0, arr1.length - 1);
    System.out.println(Arrays.toString(arr1));
//    System.out.println(kthSmallest(arr, 3));
  }

  public static int kthSmallest(int[] arr, int k){
    if (arr == null || arr.length < k) {
      return -1;
    }
    int partition = partition(arr, 0, arr.length - 1);
    while (partition + 1 != k) {
      if(partition + 1 < k){
        partition = partition(arr, partition + 1, arr.length - 1);
      }else{
        partition = partition(arr, 0, partition - 1);
      }
    }
    return arr[partition];
  }
  
  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[right];
    int i = left;
    for (int j = left; j < right; j++) {
      if (arr[j] <= pivot) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, right);
    return i;
  }

  private static int partition1(int[] arr, int left, int right) {
    int pivot = arr[right];
    while (left < right) {
      while (left < right && arr[left] <= pivot) {
        left++;
      }
      arr[right] = arr[left];
      while (left < right && arr[right] >= pivot) {
        right--;
      }
      arr[left] = arr[right];
    }
    arr[right] = pivot;
    return right;
  }

  private static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
