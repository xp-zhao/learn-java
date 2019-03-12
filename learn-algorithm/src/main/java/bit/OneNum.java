package bit;

/**
 * 正整数的二进制表示包含多少个 1
 * Created by xp-zhao on 2019/3/12.
 */
public class OneNum
{
	public static void main(String[] args) {
		System.out.println(judge(6));
//		System.out.println(method2(15));
	}

	/**
	 *  32 位的 int，每次取 n 的最低位，判断是不是 1 ，位移 32 次循环判断
	 * @param n
	 * @return
	 */
	public static int method1(int n){
		int num = 0;
		int i = 0;
		do {
			if((n & 1) == 1){
				num++;
			}
			n = n >> 1;
			i++;
		}
		while(i < 32);
		return num;
	}

	/**
	 * n & (n - 1) 可以消除最后一个 1
	 * 逐步通过 n & (n - 1) 来消除 n 二进制末尾的 1，消除了多少次，就有多少个 1
	 * @param n
	 * @return
	 */
	public static int method2(int n){
		int num = 0;
		while(n != 0){
			num++;
			n = n & (n - 1);
		}
		return num;
	}

	/**
	 * 快速判断一个正整数是不是 2 的 x次幂
	 * 如果 n 是 2 的 x 次幂，二进制表示就只有一个 1
	 * @param n
	 * @return
	 */
	public static boolean judge(int n){
		return (n & (n - 1)) == 0;
	}
}
