package dp;

/**
 * Test.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/11
 **/
public class Test {

  public static void main(String[] args) {
    int[] cost = {10, 15, 20};
    System.out.println(climbStairs(cost.length, cost));
  }

  public static int climbStairs(int n, int[] cost){
    if(n == 0 || n == 1){
      return 0;
    }
    return Math.min(climbStairs(n - 1, cost) + cost[n - 1], climbStairs(n - 2, cost) + cost[n - 2]);
  }
}