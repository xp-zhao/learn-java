package array;

/**
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 你找到的子数组应是最短的，请输出它的长度。

 示例 1:
 输入: [2, 6, 4, 8, 10, 9, 15]
 输出: 5
 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

 说明 :
 输入的数组长度范围在 [1, 10,000]。
 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * Created by xp-zhao on 2018/12/4.
 */
public class LeetCode_581_ShortestUnsortedContinuousSubarray
{
	public static void main(String[] args) {
		int[] nums = {2 , 6 , 4 , 8 , 10 , 9 , 15};
		System.out.println(findUnsortedSubarray(nums));
		int[] nums1 = {2 };
		System.out.println(findUnsortedSubarray(nums1));
		int[] nums2 = {4 , 8 , 10};
		System.out.println(findUnsortedSubarray(nums2));
		int[] nums3 = {2,3,3,2,4};
		System.out.println(findUnsortedSubarray(nums3));
		int[] nums4 = {4 , 8 , 10,10};
		System.out.println(findUnsortedSubarray(nums4));
	}

	public static int findUnsortedSubarray(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int leftStop = nums[0];
		while(left < right){
			if(nums[left] - nums[left + 1] <= 0){
				left++;
			}else{
				leftStop = left;
				break;
			}
		}
		while(left < right){
			if(nums[right] - nums[right - 1] >= 0){
				right--;
			}else{
				break;
			}
		}
		if(left == right){
			return 0;
		}
		return right - left + 1;
	}
}
