package array;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. 卡牌分组
 *给定一副牌，每张牌上都写着一个整数。
 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

 每组都有 X 张牌。
 组内所有的牌上都写着相同的整数。
 仅当你可选的 X >= 2 时返回 true。

 示例 1：
 输入：[1,2,3,4,4,3,2,1]
 输出：true
 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]

 示例 2：
 输入：[1,1,1,2,2,2,3,3]
 输出：false
 解释：没有满足要求的分组。

 示例 3：
 输入：[1]
 输出：false
 解释：没有满足要求的分组。

 示例 4：
 输入：[1,1]
 输出：true
 解释：可行的分组是 [1,1]

 示例 5：
 输入：[1,1,2,2,2,2]
 输出：true
 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * Created by xp-zhao on 2018/12/5.
 */
public class LeetCode_914_XOfAKindInADeckOfCards
{
	public static void main(String[] args) {
		int[] deck1 = {1 , 2 , 3 , 4 , 4 , 3 , 2 , 1};
		Assert.assertTrue(hasGroupsSizeX1(deck1));
		int[] deck2 = {1 , 1 , 1 , 2 , 2 , 2 , 3 , 3};
		Assert.assertFalse(hasGroupsSizeX1(deck2));
		int[] deck3 = {1};
		Assert.assertFalse(hasGroupsSizeX1(deck3));
		int[] deck4 = {1 , 1};
		Assert.assertTrue(hasGroupsSizeX1(deck4));
		int[] deck5 = {1 , 1 , 2 , 2 , 2 , 2};
		Assert.assertTrue(hasGroupsSizeX1(deck5));
		int[] deck6 = {0 , 0 , 0 , 1 , 1 , 1 , 2 , 2 , 2};
		Assert.assertTrue(hasGroupsSizeX1(deck6));
		int[] deck7 = {1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2};
		Assert.assertTrue(hasGroupsSizeX1(deck7));
	}

	public static boolean hasGroupsSizeX(int[] deck) {
		int min = deck.length;
		Map<Integer, Integer> map = new HashMap<>();
		int temp;
		for(int i = 0; i < deck.length; i++)
		{
			if(map.containsKey(deck[i])){
				temp = map.get(deck[i]) + 1;
				map.put(deck[i],temp);
			}else{
				map.put(deck[i],1);
			}
		}
		for(Integer integer : map.values())
		{
			min = Math.min(min , integer);
		}
		boolean flag;
		for(int i = 2; i <= min; i++){
			flag = true;
			for(Integer integer : map.values())
			{
				if(integer % i != 0){
					flag = false;
					break;
				}
			}
			if(flag){
				return true;
			}
		}
		return false;
	}

	public static boolean hasGroupsSizeX1(int[] deck) {
		int[] counts = new int[10000];
		for(int i = 0; i < deck.length; i++)
		{
			counts[deck[i]]++;
		}
		int min = deck.length;
		for(int i = 0; i < counts.length; i++)
		{
			if(counts[i] != 0 && counts[i] < min){
				min = counts[i];
			}
		}
		boolean flag = true;
		for(int i = 2; i <= min; i++){
			flag = true;
			for(int count : counts)
			{
				if(count % i != 0){
					flag = false;
					break;
				}
			}
			if(flag){
				break;
			}
		}
		if(flag && min >= 2){
			return true;
		}
		return false;
	}
}
