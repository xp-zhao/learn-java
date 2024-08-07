package stack;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

 示例 1：
 输入：S = "ab#c", T = "ad#c"
 输出：true
 解释：S 和 T 都会变成 “ac”。

 示例 2：
 输入：S = "ab##", T = "c#d#"
 输出：true
 解释：S 和 T 都会变成 “”。

 示例 3：
 输入：S = "a##c", T = "#a#c"
 输出：true
 解释：S 和 T 都会变成 “c”。

 示例 4：
 输入：S = "a#c", T = "b"
 输出：false
 解释：S 会变成 “c”，但 T 仍然是 “b”。

 提示：
 1 <= S.length <= 200
 1 <= T.length <= 200
 S 和 T 只含有小写字母以及字符 '#'。

 * Created by xp-zhao on 2019/1/9.
 */
public class LeetCode_844_BackspaceStringCompare
{
	public static void main(String[] args) {
		String S = "a##c";
		String T = "#a#c";
		System.out.println(backspaceCompare(S,T));
	}

	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> sstack = new Stack<>();
		Stack<Character> tstack = new Stack<>();
		for(int i = 0; i < S.length(); i++){
			if('#' == S.charAt(i) && !sstack.isEmpty()){
				sstack.pop();
			}else if('#' != S.charAt(i)){
				sstack.push(S.charAt(i));
			}
		}
		for(int i = 0; i < T.length(); i++){
			if('#' == T.charAt(i) && !tstack.isEmpty()){
				tstack.pop();
			}else if('#' != T.charAt(i)){
				tstack.push(T.charAt(i));
			}
		}
		return sstack.equals(tstack);
	}
}
