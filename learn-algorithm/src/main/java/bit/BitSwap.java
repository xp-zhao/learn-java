package bit;

import java.util.Arrays;

/**
 * @description: 位运算实现交换两个数
 * @author: zhaoxp
 * @create: 2019/05/20
 **/
public class BitSwap {

  public static void main(String[] args) {
    int[] array = {1, 2, 3};
    System.out.println(Arrays.toString(array));
    swap(array, 0, 2);
    System.out.println(Arrays.toString(array));
  }

  public static void swap(int[] array, int i, int j){
    // 常规方法交换
//    int tmp = array[i];
//    array[i] = array[j];
//    array[j] = tmp;
    // 位运算交换（两个相同的数异或之后为 0：n ^ n = 0 ，任何数与 0 异或等于本身: n ^ 0 = n）
    // x = x ^ y;
    // y = x ^ y; y = x ^ y ^ y = x ^ (y ^ y) = x ^ 0 = x
    // x = x ^ y; x = (x ^ y) ^ x = (x ^ x) ^ y = 0 ^ y = y
    array[i] = array[i] ^ array[j];
    array[j] = array[i] ^ array[j];
    array[i] = array[i] ^ array[j];
  }

}