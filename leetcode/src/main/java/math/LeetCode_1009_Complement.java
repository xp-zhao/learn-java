package math;

/**
 * LeetCode_1009_Complement.java 十进制整数的反码
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/11
 **/
public class LeetCode_1009_Complement {

  public static void main(String[] args) {
    System.out.println(bitwiseComplement(8));
  }

  public static int bitwiseComplement(int N) {
    String str = Integer.toBinaryString(N);
    char[] chars = str.toCharArray();
    int len = chars.length;
    int num = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '0') {
        num = num + (1 << (len - i - 1));
      }
    }
    return num;
  }
}