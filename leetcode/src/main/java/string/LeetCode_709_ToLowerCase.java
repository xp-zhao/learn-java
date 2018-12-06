package string;

/**
 * 709. 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

 示例 1：
 输入: "Hello"
 输出: "hello"

 示例 2：
 输入: "here"
 输出: "here"

 示例 3：
 输入: "LOVELY"
 输出: "lovely"
 * Created by xp-zhao on 2018/12/6.
 */
public class LeetCode_709_ToLowerCase
{
	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(toLowerCase(str));
	}

	public static String toLowerCase(String str) {
		char[] ch = str.toCharArray();
		int temp;
		for(int i = 0; i < ch.length; i++)
		{
			temp = (int)ch[i];
			if(temp >= 65 && temp <= 90){
				ch[i] = (char) (temp + 32);
			}
		}
		return new String(ch);
	}
}
