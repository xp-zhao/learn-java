package bit;

/**
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

 示例 1:
 输入: a = 1, b = 2
 输出: 3

 示例 2:
 输入: a = -2, b = 3
 输出: 1
 * Created by xp-zhao on 2019/1/28.
 */
public class LeetCode_371_SumOfTwoIntegers
{
	public static void main(String[] args) {
		int a = -1;
		int b = 2;
		System.out.println(getSum(a, b));
	}

	public static int getSum(int a, int b) {
		int sum;
		int carry;
		sum = a ^ b; // 异或运算，二进制位相加（不考虑进位）
		carry = (a & b) << 1; // 单独计算进位
		if(carry != 0){
			// 进位不为 0 ，将之前计算的结果加上进位
			return getSum(sum , carry);
		}
		// 进位为 0 ，直接返回
		return sum;
	}
}
