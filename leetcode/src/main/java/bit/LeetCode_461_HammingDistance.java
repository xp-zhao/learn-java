package bit;

/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * Created by xp-zhao on 2019/1/11.
 */
public class LeetCode_461_HammingDistance
{
	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		System.out.println(hammingDistance(x, y));
	}

	public static int hammingDistance(int x, int y) {
		int num = x ^ y;// 进行异或运算，将不同位变为 1 相同位为 0
		int count = 0;
		while(num > 0){
			int flag = num & 1; // 跟 1 进行与运算，判断最后一位是否为 1（flag = 1 表示最后一位为 1，flag = 0 表示最后一位为 0）
			if(flag == 1)
			{
				count++;
			}
			num = num >> 1; // 将 num 右移一位
		}
		return count;
	}
}
