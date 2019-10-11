package bit;

/**
 * LeetCode_191_HammingWeight.java 位 1 的个数
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/11
 **/
public class LeetCode_191_HammingWeight {

  public static void main(String[] args) {
    System.out.println(hammingWeight(5));
  }

  public static int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }
}