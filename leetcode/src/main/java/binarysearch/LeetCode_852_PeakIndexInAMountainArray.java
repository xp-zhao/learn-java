package binarysearch;

/**
 * 852. 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 A.length >= 3
 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

 示例 1：
 输入：[0,1,0]
 输出：1

 示例 2：
 输入：[0,2,1,0]
 输出：1
 * Created by xp-zhao on 2019/1/9.
 */
public class LeetCode_852_PeakIndexInAMountainArray
{
	public static void main(String[] args) {
		int[] nums = {0,2,1,0};
		System.out.println(peakIndexInMountainArray(nums));
	}

	public static int peakIndexInMountainArray(int[] A) {
		int left = 0;
		int right = A.length - 1;
		while(left <= right){
			int middle = right - ((right - left) >> 1);
			if(A[middle] > A[middle - 1] && A[middle] > A[middle + 1]){
				return middle;
			}else if(A[middle] > A[middle - 1]){
				left = middle + 1;
			}else{
				right = middle - 1;
			}
		}
		return -1;
	}
}
