package sort.merge;


import java.util.Arrays;

/**
 * @author zhaoxiaoping
 * @Description: 归并排序
 * @Date 2020-9-23
 **/
public class MergeSortExample {

  public static void main(String[] args) {
    int[] num = {11, 8, 3, 9, 7, 1, 2, 5};
    System.out.println(Arrays.toString(num));
    num = mergeSort(num);
    System.out.println(Arrays.toString(num));
  }

  public static int[] mergeSort(int[] num) {
    if (num == null) {
      return new int[0];
    }
    if (num.length == 1) {
      return num;
    }
    // 数组分为两半
    int mid = num.length / 2;
    int[] left = Arrays.copyOfRange(num, 0, mid);
    int[] right = Arrays.copyOfRange(num, mid, num.length);

    // 嵌套调用，对两半分进行排序
    left = mergeSort(left);
    right = mergeSort(right);

    //合并排序后的两部分
    int[] merged = merge(left, right);
    return merged;
  }

  public static int[] merge(int[] a, int[] b) {
    if (a == null) {
      a = new int[0];
    }
    if (b == null) {
      b = new int[0];
    }
    int[] merged = new int[a.length + b.length];
    int mi = 0, ai = 0, bi = 0;
    while (ai < a.length && bi < b.length) {
      if (a[ai] <= b[bi]) {
        merged[mi] = a[ai];
        ai++;
      } else {
        merged[mi] = b[bi];
        bi++;
      }
      mi++;
    }
    if (ai < a.length) {
      for (int i = ai; i < a.length; i++) {
        merged[mi] = a[i];
        mi++;
      }
    } else {
      for (int i = bi; i < b.length; i++) {
        merged[mi] = b[i];
        mi++;
      }
    }
    return merged;
  }
}
