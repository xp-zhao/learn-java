import java.util.Arrays;

/**
 *  4. 两个排序数组的中位数
 * Created by xp-zhao on 2018/8/9.
 */
public class MedianSortedArrays
{
	public static void main(String[] args)
	{
		int[] nums1 = {};
		int[] nums2 = {1};
		int[] nums = merge(nums1 , nums2);
		System.out.println(Arrays.toString(nums));
		int size = nums.length / 2;
		int flag = nums.length % 2;
		if(flag == 0){
			System.out.println((nums[size - 1] + nums[size]) / 2.0);
		}else{
			System.out.println(nums[size]);
		}
	}

	public static int[] merge(int[] nums1,int[] nums2){
		int size1 = nums1.length;
		int size2 = nums2.length;
		int[] nums = new int[size1 + size2];
		int i = 0, j = 0, k = 0;
		while(i < size1 && j < size2){
			if(nums1[i] < nums2[j]){
				nums[k++] = nums1[i++];
			}else{
				nums[k++] = nums2[j++];
			}
		}
		while(i < size1){
			nums[k++] = nums1[i++];
		}
		while(j < size2){
			nums[k++] = nums2[j++];
		}
		return nums;
	}
}
