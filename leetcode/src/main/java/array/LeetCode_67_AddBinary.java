package array;

/**
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 输入为非空字符串且只包含数字 1 和 0。

 示例 1:
 输入: a = "11", b = "1"
 输出: "100"

 示例 2:
 输入: a = "1010", b = "1011"
 输出: "10101"
 * Created by xp-zhao on 2018/12/3.
 */
public class LeetCode_67_AddBinary
{
	public static void main(String[] args) {
//		String a = "11";
//		String b = "1";
		String a = "1010";
		String b = "1011";
		System.out.println(addBinary(a,b));
	}

	public static String addBinary(String a, String b) {
		if(a.equals("0") && b.equals("0"))
		{
			return "0";
		}
		int maxLength = a.length() > b.length() ? a.length() : b.length();
		int[] arrayA = new int[maxLength + 1];
		for(int i = 0; i < a.length(); i++){
			arrayA[i] = a.charAt(a.length() - 1 - i) - '0';
		}
		int[] arrayB = new int[maxLength + 1];
		for(int i = 0; i < b.length(); i++){
			arrayB[i] = b.charAt(b.length() - 1 - i) - '0';
		}
		int[] result = new int[maxLength + 1];
		int temp = 0;
		for(int i = 0; i < result.length; i++)
		{
			temp = result[i];
			temp += arrayA[i];
			temp += arrayB[i];
			if(temp > 1){
				temp -= 2;
				result[i + 1] += 1;
			}
			result[i] = temp;
		}
		StringBuilder sb = new StringBuilder();
		boolean findFirst = false;
		for(int i = result.length - 1; i >= 0; i--)
		{
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
