/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
   每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
   注意：给定 n 是一个正整数。
 * Created by xp-zhao on 2018/9/17.
 */
public class ClimbingStairs
{
	private static int count = 0;
	public static void main(String[] args)
	{
		int n = 30;
		int[] dp = new int[n+1];
		System.out.println(climbStairs2(4));
//		System.out.println(count);
	}

	public static int climbStairs(int n) {
		count++;
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		return climbStairs(n - 1) +climbStairs(n - 2);
	}

	public static int climbStairs1(int n,int[] dp){
		count++;
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		if(0 == dp[n]){
			dp[n] = climbStairs1(n - 1 , dp) + climbStairs1(n - 2 , dp);
		}
		return dp[n];
	}

	public static int climbStairs2(int n){
		if(1 == n){
			return 1;
		}else if(2 == n){
			return 2;
		}
		int[] dp = new int[n + 1];
		int res = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < dp.length; i++){
			res = dp[i] = dp[i - 1] + dp[i - 2];
			System.out.print(res + " ");
		}
		System.out.println();
		return res;
	}

	public static int climbStairs3(int n){
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
