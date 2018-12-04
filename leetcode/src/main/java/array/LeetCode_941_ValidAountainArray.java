package array;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

	 A.length >= 3
	 在 0 < i < A.length - 1 条件下，存在 i 使得：
	 A[0] < A[1] < ... A[i-1] < A[i]
	 A[i] > A[i+1] > ... > A[B.length - 1]

	 示例 1：
	 输入：[2,1]
	 输出：false

	 示例 2：
	 输入：[3,5,5]
	 输出：false

	 示例 3：
	 输入：[0,3,2,1]
	 输出：true
 * Created by xp-zhao on 2018/12/4.
 */
public class LeetCode_941_ValidAountainArray
{
	public static void main(String[] args) {
		int[] nums1 = {2 , 0,2};
		System.out.println(validMountainArray(nums1));
		int[] nums2 = {3 , 5 , 5};
		System.out.println(validMountainArray(nums2));
		int[] num3 = {0 , 3 , 2 , 1};
		System.out.println(validMountainArray(num3));
		int[] nums4 = {0 , 1 , 2 , 3 , 4 , 8 , 9};
		System.out.println(validMountainArray(nums4));
	}

	public static boolean validMountainArray(int[] A) {
		if(A.length < 3){
			return false;
		}
		int left = 0;
		int right = A.length - 1;
		boolean leftStop = false;
		boolean rightStop = false;
		while(left < right){
			if(!leftStop){
				if(A[left] - A[left + 1] < 0){
					left++;
				}else if(A[left] - A[left + 1] > 0){
					leftStop = true;
					if(left == 0){
						return false;
					}
				}else{
					return false;
				}
			}
			if(!rightStop){
				if(A[right] - A[right - 1] < 0){
					right--;
				}else if(A[right] - A[right - 1] > 0){
					rightStop = true;
					if(right == A.length - 1){
						return false;
					}
				}else{
					return false;
				}
			}
			if(leftStop && rightStop){
				break;
			}
		}
		if(left != right){
			return false;
		}
		return true;
	}
}
