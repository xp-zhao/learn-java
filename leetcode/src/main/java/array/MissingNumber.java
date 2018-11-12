package array;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 	输入: [3,0,1]
 	输出: 2
 * Created by xp-zhao on 2018/11/12.
 */
public class MissingNumber
{
	public static void main(String[] args)
	{
		int[] arry = {3,0,1};
		int[] arry2 = {9 , 6 , 4 , 2 , 3 , 5 , 7 , 0 , 1};
		int length = arry2.length;
		int total = length * (length + 1) / 2;
		int result = 0;
		for(int i : arry2)
		{
			result += i;
		}
		System.out.println(total - result);
	}
}
