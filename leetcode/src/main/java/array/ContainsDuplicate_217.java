package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
   如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

	 示例 1:
	 输入: [1,2,3,1]
	 输出: true

	 示例 2:
	 输入: [1,2,3,4]
	 输出: false
 * Created by xp-zhao on 2018/11/14.
 */
public class ContainsDuplicate_217
{
	public static void main(String[] args)
	{
		int[] nums = {1 , 2 , 3 , 1};
		Set set = new HashSet();
		for(int num : nums){
			if(!set.add(num)){
				System.out.println(true);
				return;
			}
		}
		System.out.println(true);
	}
}
