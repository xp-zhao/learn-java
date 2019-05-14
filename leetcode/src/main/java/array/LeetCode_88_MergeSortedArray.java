package array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
	 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
	 说明:
	 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

	 示例:
	 输入:
	 nums1 = [1,2,3,0,0,0], m = 3
	 nums2 = [2,5,6],       n = 3

	 输出: [1,2,2,3,5,6]
 * Created by xp-zhao on 2018/12/1.
 */
public class LeetCode_88_MergeSortedArray
{
	public static void main(String[] args){
		int[] nums1 = {2 , 0};
		int m = 1;
		int[] nums2 = {1};
		int n = 1;
		merge1(nums1,m,nums2,n);
		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for(int i = m; i < m + n; i++)
		{
			nums1[i] = nums2[i - m];
		}
		Arrays.sort(nums1);
	}

	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		for(int i = m; i < m + n; i++)
		{
			nums1[i] = nums2[i - m];
			int j = i;
			while(i > 0 && j > 0 && nums1[j] < nums1[j - 1])
			{
				int temp = nums1[j];
				nums1[j] = nums1[j - 1];
				nums1[j - 1] = temp;
				j--;
			}
		}
//		Arrays.sort(nums1);
	}
}
