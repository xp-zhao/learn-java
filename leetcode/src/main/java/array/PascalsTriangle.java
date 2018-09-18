package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * Created by xp-zhao on 2018/9/18.
 */
public class PascalsTriangle
{
	public static void main(String[] args)
	{
		int n = 5;
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
}
