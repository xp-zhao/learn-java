package string;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * Created by xp-zhao on 2019/3/14.
 */
public class LeetCode_394_DecodeString
{
	public static void main(String[] args) {
//		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
//		System.out.println(decodeString("2[abc]3[cd]ef"));
	}

	public static String decodeString(String s) {
		Stack<Integer> numStack = new Stack<>(); // 保存字符串重复的次数
		Stack<String> strStack = new Stack<>();  // 保存已经解析的字符串

		String res = "";  // 临时存放已经解析的字符串
		int index = 0;
		while(index < s.length()){
			if(Character.isDigit(s.charAt(index))){
				// 获取字符前面的数字，并放入 numStack 中
				int count = 0;
				while(Character.isDigit(s.charAt(index))){
					count = 10 * count + (s.charAt(index) - '0');
					index++;
				}
				numStack.push(count);
			}else if(s.charAt(index) == '['){
				// 将已经解析的字符串放入栈 strStack 中
				strStack.push(res);
				res = "";
				index++;
			}else if(s.charAt(index) == ']'){
				// 解析完一组字符串，此时 res 中存放了 [] 之间的字符串
				// 将之前已经解析完了的字符串放在新字符串头部
				StringBuilder sb = new StringBuilder(strStack.pop());
				// res 重复次数
				int num = numStack.pop();
				for(int i = 0; i < num; i++)
				{
					sb.append(res);
				}
				// 将解析完的字符串存入 res
				res = sb.toString();
				index++;

			}else{
				res += s.charAt(index++);
			}
		}
		return res;
	}
}
