package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

 返回重复了 N 次的那个元素。

 示例 1：
 输入：[1,2,3,3]
 输出：3

 示例 2：
 输入：[2,1,2,5,3,2]
 输出：2

 示例 3：
 输入：[5,1,5,2,5,3,5,4]
 输出：5
 * Created by xp-zhao on 2019/1/24.
 */
public class LeetCode_961_NRepeatedElementInSize2nArray
{
	public static void main(String[] args) {
		int[] nums = {1 , 2 , 3 , 3};
		System.out.println(repeatedNTimes(nums));
	}

	public static int repeatedNTimes(int[] A) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < A.length; i++)
		{
			if(!set.add(A[i])){
				return A[i];
			}
		}
		return 0;
	}
}
