package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 888. 公平的糖果交换
 *
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

 如果有多个答案，你可以返回其中任何一个。保证答案存在。

 示例 1：
 输入：A = [1,1], B = [2,2]
 输出：[1,2]

 示例 2：
 输入：A = [1,2], B = [2,3]
 输出：[1,2]

 示例 3：
 输入：A = [2], B = [1,3]
 输出：[2,3]

 示例 4：
 输入：A = [1,2,5], B = [2,4]
 输出：[5,4]
 * Created by xp-zhao on 2018/11/16.
 */
public class FairCandySwap_888
{
	public static void main(String[] args)
	{
		int A[] = {1 , 2 , 5};
		int B[] = {2 , 4};
		int[] result = fairCandySwap(A , B);
		System.out.println(Arrays.toString(result));
	}

	/**
	 * 方程式： A 给出 x 获取 y ，则 A - x + y = B - y + x
	 *   y = x + (B - A) / 2;
	 * @param A
	 * @param B
	 * @return
	 */
	public static int[] fairCandySwap(int[] A, int[] B) {
		int SumA = 0;
		int SumB = 0;
		Set<Integer> set = new HashSet<>();
		for(int a : A){
			SumA += a;
		}
		for(int b : B){
			SumB += b;
			set.add(b);
		}
		int Sum = (SumB - SumA) / 2;

		for(int a : A){
			if(set.contains( a + Sum)){
				return new int[]{a,a+Sum};
			}
		}
		return null;
	}
}
