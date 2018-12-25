package TopN;

import java.util.Arrays;

/**
 * 分治法解决 TopN 问题
 * Created by xp-zhao on 2018/12/25.
 */
public class DivideAndConquer
{
	public static void main(String[] args) {
		int[] nums = {56 , 30 , 71 , 18 , 29 , 93 , 44 , 75 , 20 , 65 , 68 , 34};
//		int[] nums = {3,1,2,4,6,5};
		System.out.println(Arrays.toString(getTopN(5,nums,0,nums.length - 1)));
	}

	public static int[] getTopN(int n,int[] nums,int left,int right){
		int middle = positon(nums,left,right);
		while(n != middle){
			if(n > middle){
				middle = positon(nums , middle + 1 , nums.length - 1);
			}else if(n < middle){
				middle = positon(nums , left , middle - 1);
			}
		}
		return Arrays.copyOf(nums , n);
	}

	public static int positon(int[] nums,int left,int right){
		int partition = nums[left];
		while(left < right){
			while(left < right && nums[right] <= partition){
				right--;
			}
			nums[left] = nums[right];
			while(left < right && nums[left] >= partition){
				left++;
			}
			nums[right] = nums[left];
		}
		nums[left] = partition;
		return left;
	}
}
