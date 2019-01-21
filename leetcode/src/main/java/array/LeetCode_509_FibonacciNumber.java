package array;

/**
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 给定 N，计算 F(N)。

 * Created by xp-zhao on 2019/1/14.
 */
public class LeetCode_509_FibonacciNumber
{
	public static void main(String[] args) {
		int n = 5;
		System.out.println(fibLoopLessMemory(n));
	}

	/**
	 * 递归解法
	 * @param N
	 * @return
	 */
	public static int fib(int N) {
		if(N == 0){
			return 0;
		}
		if(N == 1){
			return 1;
		}
		return fib(N - 1) + fib(N - 2);
	}

	/**
	 * 递归-动态规划
	 * @param N
	 * @return
	 */
	public static int fibDp(int N){
		int[] dp = new int[N + 1];
		return fibDp(N , dp);
	}

	private static int fibDp(int N, int[] dp){
		if(N == 0){
			return 0;
		}
		if(N == 1){
			return 1;
		}
		if(0 == dp[N]){
			dp[N] =fibDp(N - 1, dp) + fibDp(N - 2, dp);
		}
		return dp[N];
	}

	/**
	 * 循环-动态规划
	 * @param N
	 * @return
	 */
	public static int fibLoop(int N){
		if(N == 0){
			return 0;
		}
		if(N == 1){
			return 1;
		}
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		int result = 0;
		for(int i = 2; i <= N; i++){
			result = dp[i] = dp[i - 1] + dp[i - 2];
		}
		return result;
	}

	/**
	 * 循环-动态规划-内存优化
	 * @param N
	 * @return
	 */
	public static int fibLoopLessMemory(int N){
		if(N == 0){
			return 0;
		}
		if(N == 1){
			return 1;
		}
		int temp1 = 0;
		int temp2 = 1;
		int result = 0;
		for(int i = 2; i <= N; i++){
			result = temp1 + temp2;
			temp1 = temp2;
			temp2 = result;
		}
		return result;
	}
}
