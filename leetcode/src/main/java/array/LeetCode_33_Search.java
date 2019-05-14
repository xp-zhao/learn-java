package array;

/**
 * @description: 搜索旋转排序数组 假设按照升序排序的数组在预先未知的某个点上进行了旋转。 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
 * )。 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1: 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4
 *
 * 示例 2: 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 * @author: zhaoxp
 * @create: 2019/05/14
 **/
public class LeetCode_33_Search {

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(search(nums, 0));
  }

  private static int search(int[] array, int value) {
    // 找到分隔点的下标
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (array[mid] > array[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    int tmp = left;
    left = 0;
    right = array.length - 1;
    if (array[tmp] <= value && value <= array[right]) {
      left = tmp;
    } else {
      right = tmp;
    }
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (array[mid] == value) {
        return mid;
      } else if (array[mid] > value) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}