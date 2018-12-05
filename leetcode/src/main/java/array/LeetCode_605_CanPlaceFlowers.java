package array;

/**
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

 示例 1:
 输入: flowerbed = [1,0,0,0,1], n = 1
 输出: True

 示例 2:
 输入: flowerbed = [1,0,0,0,1], n = 2
 输出: False
 * Created by xp-zhao on 2018/12/5.
 */
public class LeetCode_605_CanPlaceFlowers
{
	public static void main(String[] args) {
		int[] nums = {0,0};
		int n1 = 1;
		int n2 = 2;
		System.out.println(canPlaceFlowers(nums,n1));
		System.out.println(canPlaceFlowers(nums,n2));
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(flowerbed.length == 1 && flowerbed[0] == 0){
			return true;
		}
		int count = 0;
		int right = flowerbed.length - 1;
		for(int i = 0; i < flowerbed.length; i++)
		{
			if(i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0){
				count++;
				flowerbed[i] = 1;
			}
			if(i == right && flowerbed[right] == 0 && flowerbed[right - 1] == 0){
				count++;
				flowerbed[right] = 1;
			}
			if(i > 1 && i < right - 1){
				if(flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
					count++;
					flowerbed[i] = 1;
				}
			}
		}
		if(count >= n){
			return true;
		}
		return false;
	}
}
