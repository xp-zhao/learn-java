import java.util.Arrays;

/**
 *  两个排序数组的中位数
 * Created by xp-zhao on 2018/8/9.
 */
public class MedianSortedArrays
{
	public static void main(String[] args)
	{
		int[] nums1 = {1 , 2, 3, 4};
		int[] nums2 = {3 , 4, 5};
		System.out.println(method(nums1,nums2));
	}

	public static float method(int[] nums1,int[] nums2){
		float result = 0;
		int index = 0;
//		int[] nums = Arrays.copyOf(nums1,nums1.length + nums2.length);
		int[] nums = new int[nums1.length+nums2.length];
		int i = 0, j = 0;
		while(i < nums1.length && j < nums2.length){
			if(nums1[i] > nums2[j]){
				nums[index++] = nums2[j++];
			}else {
				nums[index++] = nums1[i++];
			}
		}
		while(i < nums1.length){
			nums[index++] = nums1[i++];
		}
		while(j < nums2.length){
			nums[index++] = nums2[j++];
		}
		System.out.println(Arrays.toString(nums));
		float k = (float) (nums.length / 2.0);
		int flag = nums.length % 2;
		if(flag == 0){
			result = (float) (nums[(int) k] + nums[(int) k - 1]/ 2.0);
		}else{
			result = (float) (nums[(int) (k - 0.5)] / 2.0);
		}
		System.out.println(nums.length);
		return result;
	}
}
