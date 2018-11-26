package array;

import java.util.Arrays;

/**
 * 大整数求和
 * Created by xp-zhao on 2018/11/21.
 */
public class BigNumberSum
{
	public static void main(String[] args)
	{
		System.out.println(bigNumberSum("426709752318","95481253129"));
	}

	public static String bigNumberSum(String bigNumberA,String bigNumberB){
		int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();
		// 将需要相加的整数用数组逆序存储
		int[] arrayA = new int[maxLength + 1];
		for(int i = 0; i < bigNumberA.length(); i++){
			arrayA[i] = bigNumberA.charAt(bigNumberA.length() - 1 - i) - '0';
		}
		System.out.println(Arrays.toString(arrayA));
		int[] arrayB = new int[maxLength + 1];
		for(int i = 0; i < bigNumberB.length(); i++){
			arrayB[i] = bigNumberB.charAt(bigNumberB.length() - 1 - i) - '0';
		}
		System.out.println(Arrays.toString(arrayB));
		// 结果的长度等于较大整数长度 + 1
		int[] result = new int[maxLength + 1];
		// 遍历数组按位相加
		for(int i = 0; i < result.length; i++){
			int temp = result[i];
			temp += arrayA[i];
			temp += arrayB[i];
			// 判断是否进位
			if(temp > 10){
				temp = temp - 10;
				result[i + 1] = 1;
			}
			result[i] = temp;
		}
		// 将相加结果数组逆序并转成 String
		StringBuilder sb = new StringBuilder();
		boolean findFirst = false;
		for(int i = result.length - 1; i >= 0; i--){
			if(!findFirst){
				if(result[i] == 0){
					continue;
				}
				findFirst = true;
			}
			sb.append(result[i]);
		}
		return sb.toString();
	}
}
