package hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。

 示例:
 输入: 10
 输出: 4
 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * Created by xp-zhao on 2019/1/24.
 */
public class LeetCode_204_CountPrimes
{
	public static void main(String[] args) {
		System.out.println(countPrimes1(499979));
	}

	/**
	 * 常规解法（耗时较长）
	 * @param n
	 * @return
	 */
	public static int countPrimes(int n) {
		if(n < 2){
			return 0;
		}
		int count = 0;
		List<Integer> list = new ArrayList<>();
		for(int i = 2; i < n; i++)
		{
			if(isPrimes(i)){
				list.add(i);
				count++;
			}
		}
		System.out.println(list);
		return count;
	}

	public static boolean isPrimes(int num){
		for(int i = 2; i < num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * 优秀解法
	 * @param n
	 * @return
	 */
	public static int countPrimes1(int n) {
		if(n < 2){
			return 0;
		}
		boolean[] flags = new boolean[n + 1];
		for(int i = 0; i < flags.length; i++)
		{
			flags[i] = true;
		}
		flags[0] = false;
		flags[1] = false;
		int count = 0;
		for(int i = 2; i < n; i++){
			if(flags[i]){
				count++;
			}else{
				continue;
			}
			int j = 2;
			while(i * j < n){
				flags[i * j] = false;
				j++;
			}
		}
		return count;
	}
}
