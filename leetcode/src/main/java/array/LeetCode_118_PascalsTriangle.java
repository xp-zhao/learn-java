package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * Created by xp-zhao on 2018/9/18.
 */
public class LeetCode_118_PascalsTriangle
{
	public static void main(String[] args)
	{
		int n = 6;
		solution1(n);
		System.out.println(solution2(n));
	}

	/**
	* @Description: 个人解法（比较丑陋，结果正确 但代码不易读 且不能一眼看出解法）
	* @Param:
	* @return:
	* @Author: zhaoxp
	* @Date: 2019/5/9
	*/
	private static void solution1(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> num;
		List<Integer> temp = new ArrayList<>();
		for(int i = 1; i <= n; i++)
		{
			num = new ArrayList<>();
			for(int j = 0; j < i; j++)
			{
				if(i == 1 || i == 2)
				{
					num.add(1);
				}
				else
				{
					if(j != 0 && j != i - 1)
					{
						num.add(temp.get(j - 1) + temp.get(j));
					}
					else{
						num.add(1);
					}
				}
			}
			temp = num;
			result.add(num);
		}
		System.out.println(result);
	}

	/**
	* @Description: 网上看到的优质解法
	* @Param:
	* @return:
	* @Author: zhaoxp
	* @Date: 2019/5/9
	*/
	private static List<List<Integer>> solution2(int n){
		List<List<Integer>> result = new ArrayList<>(n);
		if(n < 1){
			return result;
		}
		for (int i = 0; i < n; i++) {
			List<Integer> list = Arrays.asList(new Integer[i + 1]);
			// 每行的第一位和最后一位数字都是 1
			list.set(0, 1);
			list.set(i, 1);
			for (int j = 1; j < i; j++) {
				// 第三行开始，中间数字等于上一行左右两个数字之和
				list.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
			}
			result.add(list);
		}
		return result;
	}
}
