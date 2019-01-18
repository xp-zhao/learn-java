package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

 示例:
 输入: S = "a1b2"
 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

 输入: S = "3z4"
 输出: ["3z4", "3Z4"]

 输入: S = "12345"
 输出: ["12345"]

 注意：
 S 的长度不超过12。
 S 仅由数字和字母组成。
 *
 * Created by xp-zhao on 2019/1/18.
 */
public class LeetCode_784_LetterCasePermutation
{
	public static void main(String[] args) {
		String str = "a1b2";
		System.out.println(letterCasePermutation(str));
	}

	public static List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		backTrace(S.toCharArray(), result, new StringBuilder(), 0);
		return result;
	}

	private static void backTrace(char[] chars, List<String> result, StringBuilder sb, int i){
		if(i == chars.length){
			result.add(sb.toString());
			return;
		}
		char ch = chars[i];
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			sb.append(Character.toLowerCase(ch));
			backTrace(chars, result, sb, i+1);
			sb.deleteCharAt(sb.length()-1);

			sb.append(Character.toUpperCase(ch));
			backTrace(chars, result, sb, i+1);
			sb.deleteCharAt(sb.length()-1);
		}
		else {
			sb.append(ch);
			backTrace(chars, result, sb, i+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
