package bit;

/**
 * 693. 交替位二进制数
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。

 示例 1:
 输入: 5
 输出: True
 解释:
 5的二进制数是: 101

 示例 2:
 输入: 7
 输出: False
 解释:
 7的二进制数是: 111

 示例 3:
 输入: 11
 输出: False
 解释:
 11的二进制数是: 1011

 示例 4:
 输入: 10
 输出: True
 解释:
 10的二进制数是: 1010
 * Created by xp-zhao on 2019/1/11.
 */
public class LeetCode_693_BinaryNumberWithAlternatingBits
{
	public static void main(String[] args) {
		int num = 7;
		System.out.println(hasAlternatingBits(num));
	}

	public static boolean hasAlternatingBits(int n) {
		int temp = n & 1;
		n = n >> 1;
		while(n > 0){
			int flag = n & 1;
			if(temp == flag){
				return false;
			}
			temp = flag;
			n = n >> 1;
		}
		return true;
	}
}
