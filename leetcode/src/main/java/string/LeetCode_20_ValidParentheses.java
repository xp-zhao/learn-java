package string;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 有效字符串需满足：

	 左括号必须用相同类型的右括号闭合。
	 左括号必须以正确的顺序闭合。
	 注意空字符串可被认为是有效字符串。
 * Created by xp-zhao on 2019/1/4.
 */
public class LeetCode_20_ValidParentheses
{
	public static void main(String[] args) {
		String s1 = "()";
		System.out.println(isValid(s1));
		String s2 = "()[]{}";
		System.out.println(isValid(s2));
		String s3 = "(]";
		System.out.println(isValid(s3));
		String s4 = "([)]";
		System.out.println(isValid(s4));
		String s5 = "{[]}";
		System.out.println(isValid(s5));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if(c == '(' || c == '[' || c== '{')
			{
				stack.push(c);
			}
			else
			{
				if(stack.isEmpty())
				{
					return false;
				}
				char topChar = stack.pop();
				if((c == ')' && topChar != '(') || (c == ']' && topChar != '[') || (c == '}' && topChar != '{'))
				{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
