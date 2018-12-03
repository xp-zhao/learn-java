package array;

import java.util.Arrays;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:
 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。

 示例 2:
 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 * Created by xp-zhao on 2018/12/3.
 */
public class LeetCode_66_PlusOne
{
	public static void main(String[] args) {
		int[] nums1 = {1 , 2 , 3};
		System.out.println(Arrays.toString(plusOne(nums1)));
		System.out.println(Arrays.toString(plusOne1(nums1)));
		int[] nums2 = {4 , 3 , 2 , 1};
		System.out.println(Arrays.toString(plusOne(nums2)));
		System.out.println(Arrays.toString(plusOne1(nums2)));
		int[] nums3 = {9 , 9};
		System.out.println(Arrays.toString(plusOne(nums3)));
		System.out.println(Arrays.toString(plusOne1(nums3)));
	}

	public static int[] plusOne(int[] digits) {
		int[] result = new int[digits.length + 1];
		int sum = 0;
		int carry = 0;
		int j = result.length - 1;
		for(int i = digits.length - 1; i >= 0; i--)
		{
			if(i == digits.length - 1){
				sum = digits[i] + 1;
			}else{
				sum = digits[i] + carry;
				carry = 0;
			}
			if(sum >= 10){
				result[j] = sum - 10;
				carry = 1;
			}else{
				result[j] = sum;
			}
			j--;
		}
		result[j] = carry;
		if(result[0] == 0){
			int[] temp = new int[result.length - 1];
			for(int i = 1; i < result.length; i++)
			{
				temp[i - 1] = result[i];
			}
			return temp;
		}
		return result;
	}

	public static int[] plusOne1(int[] digits){
		digits[digits.length - 1] += 1;
		for(int i = digits.length - 1; i >= 0; i--)
		{
			if(digits[i] < 10){
				return digits;
			}else{
				digits[i] = 0;
				if(i != 0){
					digits[i - 1] += 1;
				}
			}
		}
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		System.arraycopy(digits,0,result,1,digits.length);
		return  result;
	}
}
