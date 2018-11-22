package dp;

/**
 * 746. 使用最小花费爬楼梯
	 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
	 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
	 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

	 示例 1:
	 输入: cost = [10, 15, 20]
	 输出: 15
	 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。

 	 示例 2:
	 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
	 输出: 6
	 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * Created by xp-zhao on 2018/11/22.
 */
public class LeetCode_764_MinCostClimbingStairs
{
	public static void main(String[] args)
	{
		int[] cost = {10 , 15 , 20};
//		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int[] dp = new int[cost.length + 1];
		System.out.println(minCostClimbingStairs_recursion(cost.length,cost));
		System.out.println(minCostClimbingStairs_dp_recursion(cost.length,cost,dp));
		System.out.println(minCostClimbingStairs_dp_loop(cost));
		System.out.println(minCostClimbingStairs_dp_loop_lessMemory(cost));
	}

	/**
	 * 递归
	 * 状态转移方程： dp[i] = min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2])
	 *  dp[1] = dp[2] = 0（dp[i] 表示到达第 i 层所需的最新花费-- 不包含 cost[i] 本身的花费）
	 * @param n
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs_recursion(int n, int[] cost) {
		if(0 == n || 1 == n){
			return 0;
		}
		return Math.min(minCostClimbingStairs_recursion(n - 2 , cost) + cost[n - 2] ,
			minCostClimbingStairs_recursion(n - 1 , cost) + cost[n - 1]);
	}

	/**
	 * 递归-动态规划
	 * 状态转移方程： dp[i] = min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2])
	 *  dp[1] = dp[2] = 0（dp[i] 表示到达第 i 层所需的最新花费-- 不包含 cost[i] 本身的花费）
	 * @param n
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs_dp_recursion(int n, int[] cost,int[] dp) {
		if(0 == n || 1 == n){
			return 0;
		}
		if(0 == dp[n]){
			dp[n] = Math.min(minCostClimbingStairs_dp_recursion(n - 2 , cost , dp) + cost[n - 2] ,
				minCostClimbingStairs_dp_recursion(n - 1 , cost , dp) + cost[n - 1]);
		}
		return dp[n];
	}

	/**
	 * 循环-动态规划
	 * 状态转移方程： dp[i] = min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2])
	 *  dp[1] = dp[2] = 0（dp[i] 表示到达第 i 层所需的最新花费-- 不包含 cost[i] 本身的花费）
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs_dp_loop(int[] cost) {
		int[] dp = new int[cost.length + 1];
		for(int i = 2; i < dp.length; i++){
			dp[i] = Math.min(dp[i - 1] + cost[i - 1] , dp[i - 2] + cost[i - 2]);
		}
		return dp[cost.length];
	}

	/**
	 * 循环-动态规划-内存优化
	 * 状态转移方程： dp[i] = min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2])
	 *  dp[1] = dp[2] = 0（dp[i] 表示到达第 i 层所需的最新花费-- 不包含 cost[i] 本身的花费）
	 * @param cost
	 * @return
	 */
	public static int minCostClimbingStairs_dp_loop_lessMemory(int[] cost) {
		int res;
		int temp1 = cost[0];
		int temp2 = cost[1];
		for(int i = 2; i < cost.length; i++){
			res = Math.min(temp1,temp2) + cost[i];
			temp1 = temp2;
			temp2 = res;
		}
		return Math.min(temp1,temp2);
	}
}
