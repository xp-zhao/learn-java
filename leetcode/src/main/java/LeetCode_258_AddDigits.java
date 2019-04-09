/**
 * 258. 各位相加
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 * Created by xp-zhao on 2019/4/9.
 */
public class LeetCode_258_AddDigits
{
	public static void main(String[] args) {
		int num = 38;
		System.out.println(addDigits2(num));
	}

	public static int addDigits(int num) {
		if(num < 10){
			return num;
		}
		String str = String.valueOf(num);
		char[] ch = str.toCharArray();
		int count = 0;
		for(char c : ch)
		{
			count += c - '0';
		}
		if(count < 10){
			return count;
		}
		return addDigits(count);
	}

	public static int addDigits1(int num){
		if(num / 10 == 0){
			return num;
		}
		int sum = 0;
		while(num != 0){
			int temp = num % 10;
			num = num / 10;
			sum += temp;
		}
		if(sum < 10){
			return sum;
		}
		return addDigits(sum);
	}

	public static int addDigits2(int num){
		return 1 + (num - 1) % 9;
	}
}
