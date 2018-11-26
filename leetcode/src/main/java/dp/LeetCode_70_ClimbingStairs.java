package dp;

/**
 * 70. 爬楼梯
	 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 注意：给定 n 是一个正整数。

	 示例 1：
	 输入： 2
	 输出： 2
	 解释： 有两种方法可以爬到楼顶。
	 1.  1 阶 + 1 阶
	 2.  2 阶

	 示例 2：
	 输入： 3
	 输出： 3
	 解释： 有三种方法可以爬到楼顶。
	 1.  1 阶 + 1 阶 + 1 阶
	 2.  1 阶 + 2 阶
	 3.  2 阶 + 1 阶
 * Created by xp-zhao on 2018/11/22.
 */
public class LeetCode_70_ClimbingStairs
{
	public static void main(String[] args)
	{
		int n = 10;
		int[] dp = new int[n + 1];
		System.out.println(climbingStairs_recursion(n));
		System.out.println(climbingStairs_dp_recursion(n,dp));
		System.out.println(climbingStairs_dp_loop(n));
		System.out.println(climbingStairs_dp_loop_lessMemory(n));
	}

	/**
	 * 递归
	 * 状态转移方程： dp[i] = dp[i - 1] + dp[i - 2]
	 *    dp[1] = 1; dp[2] = 2
	 * @param n
	 * @return
	 */
	public static int climbingStairs_recursion(int n){
		if(1 == n){
			return 1;
		}else if(2 == n){
			return 2;
		}
		return climbingStairs_recursion(n - 1) + climbingStairs_recursion(n - 2);
	}

	/**
	 * 递归-动态规划
	 * 状态转移方程： dp[i] = dp[i - 1] + dp[i - 2]
	 *    dp[1] = 1; dp[2] = 2
	 * @param n
	 * @return
	 */
	public static int climbingStairs_dp_recursion(int n,int[] dp){
		if(1 == n){
			return 1;
		}else if(2 == n){
			return 2;
		}
		if(0 == dp[n]){
			dp[n] = climbingStairs_dp_recursion(n - 1 , dp) + climbingStairs_dp_recursion(n - 2 , dp);
		}
		return dp[n];
	}

	/**
	 * 循环-动态规划
	 * 状态转移方程： dp[i] = dp[i - 1] + dp[i - 2]
	 *    dp[1] = 1; dp[2] = 2
	 * @param n
	 * @return
	 */
	public static int climbingStairs_dp_loop(int n){
		if(1 == n){
			return 1;
		}else if(2 == n){
			return 2;
		}
		int[] dp = new int[n + 1];
		int res = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < n + 1; i++){
			res = dp[i] = dp[i - 1] + dp[i - 2];
		}
		return res;
	}

	/**
	 * 循环-动态规划-内存优化
	 * 状态转移方程： dp[i] = dp[i - 1] + dp[i - 2]
	 *    dp[1] = 1; dp[2] = 2
	 * @param n
	 * @return
	 */
	public static int climbingStairs_dp_loop_lessMemory(int n){
		if(1 == n){
			return 1;
		}else if(2 == n){
			return 2;
		}
		int res = 0;
		int temp1 = 1;
		int temp2 = 2;
		for(int i = 3; i < n + 1; i++){
			res = temp1 + temp2;
			temp1 = temp2;
			temp2 = res;
		}
		return res;
	}
}
