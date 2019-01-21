package binarysearch;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:
 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2]

 示例 2:
 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [9,4]
 * Created by xp-zhao on 2019/1/9.
 */
public class LeetCode_349_IntersectionOfTwoArrays
{
	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {9,4,9,8,4};
		System.out.println(Arrays.toString(intersection1(nums1,nums2)));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> list1 = Arrays.stream(nums1).distinct().boxed().collect(toList());
		List<Integer> list2 = Arrays.stream(nums2).distinct().boxed().collect(toList());
		list1.retainAll(list2);
		return list1.stream().mapToInt(Integer::intValue).toArray();
	}

	public static int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		for(int i = 0; i < nums1.length; i++)
		{
			set1.add(nums1[i]);
		}
		Set<Integer> set2 = new HashSet<>();
		for(int i = 0; i < nums2.length; i++)
		{
			if(set1.contains(nums2[i])){
				set2.add(nums2[i]);
			}
		}
		int[] result = new int[set2.size()];
		int j = 0;
		for(Integer integer : set2)
		{
			result[j++] = integer;
		}
		return result;
	}
}
