package array;

/**
 * 121. 买卖股票的最佳时机
 *	给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 	如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 	注意你不能在买入股票前卖出股票。

	 输入: [7,1,5,3,6,4]
	 输出: 5
	 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

	 输入: [7,6,4,3,1]
	 输出: 0
	 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 * Created by xp-zhao on 2018/11/12.
 */
public class Stock121
{
	public static void main(String[] args)
	{
		int[] prices = {7 , 1 , 5 , 3 , 6 , 4};
//		int[] prices = {7 , 6 , 5 , 4 , 3 , 1};
//		int[] prices = {2 , 4 , 1};
		maxProfit(prices);
	}

	/**
	 * 自己的(暴力解法)
	 * @param prices
	 */
	public static void max(int[] prices)
	{
		int max = 0;
		int result = 0;
		for(int i = 0; i < prices.length; i++)
		{
			for(int j = i + 1; j < prices.length; j++)
			{
				result = prices[j] - prices[i];
				if(result > max)
				{
					max = result;
				}
			}
		}
		System.out.println(max);
	}

	/**
	 * 优化解法
	 * @param prices
	 */
	public static void maxProfit(int[] prices)
	{
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < prices.length; i++)
		{
			if(prices[i] < min)
			{
				min = prices[i];
			}
			else if(prices[i] - min > max)
			{
				max = prices[i] - min;
			}
		}
		System.out.println(max);
	}
}
