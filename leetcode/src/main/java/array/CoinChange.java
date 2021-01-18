package array;

/**
 * @Author: xp-zhao @Description: 硬币问题，输入一个目标金额 n，返回凑出目标金额 n 的最少硬币数量 @DateTime: 2021/1/18 10:43 下午
 */
public class CoinChange {

  int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int sup = coinChange(coins, amount - coin);
      if (sup == -1) {
        continue;
      }
      min = Math.min(min, sup + 1);
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int amount = 11;
    CoinChange coinChange = new CoinChange();
    System.out.println(coinChange.coinChange(coins, amount));
  }
}
