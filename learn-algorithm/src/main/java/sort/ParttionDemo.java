package sort;

/**
 * @description: O(n) 的时间复杂度内求无序数组中的第 K 大元素
 *  利用分区的思想
 * @author: zhaoxp
 * @create: 2019/05/14
 **/
public class ParttionDemo {

  public static void main(String[] args) {
    int[] nums = {4, 2, 5, 12, 3};
    System.out.println(find(nums, 5));
  }

  public static int find(int[] array, int num) {
    int mid_index = parttion(array, 0, array.length - 1);
    int length = array.length - 1;
    while (length - mid_index != num - 1){
      if (length > num - 1) {
        mid_index = parttion(array, mid_index + 1, array.length - 1);
      } else {
        mid_index = parttion(array, 0, mid_index - 1);
      }
    }
    return array[mid_index];
  }

  public static int parttion(int[] array, int left, int right) {
    int pivot = array[right];
    int index = left;
    for (int i = left; i <= right - 1; i++) {
      if (array[i] < pivot) {
        swap(array, i, index);
        index++;
      }
    }
    swap(array, index, right);
    return index;
  }

  private static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}