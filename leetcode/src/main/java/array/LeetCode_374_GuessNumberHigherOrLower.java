package array;

/**
 * 374. 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 每次你猜错了，我会告诉你这个数字是大了还是小了。
 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：

 -1 : 我的数字比较小
 1 : 我的数字比较大
 0 : 恭喜！你猜对了！
 示例 :

 输入: n = 10, pick = 6
 输出: 6
 * Created by xp-zhao on 2018/11/30.
 */
public class LeetCode_374_GuessNumberHigherOrLower
{
	public static void main(String[] args) {
		int n = 1;
		System.out.println(guessNumber(n));
	}

	public static int guessNumber(int n) {
		int left = 1;
		int right = n;
		int middle = 0;
		while(left < right){
			middle = left + (right - left) / 2;
			if(guess(middle) == 1){
				left = middle + 1;
			}else if(guess(middle) == -1){
				right = middle - 1;
			}else {
				return middle;
			}
		}
		return left;
	}

	public static int guess(int num){
		if(num > 6){
			return -1;
		}else if(num < 6){
			return 1;
		}else{
			return 0;
		}
	}
}
