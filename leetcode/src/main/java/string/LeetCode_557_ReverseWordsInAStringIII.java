package string;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 示例 1:
 输入: "Let's take LeetCode contest"
 输出: "s'teL ekat edoCteeL tsetnoc"
 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * Created by xp-zhao on 2018/12/6.
 */
public class LeetCode_557_ReverseWordsInAStringIII
{
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		String[] strs = s.split(" ");
		char[] temp;
		int left;
		int right;
		char ch;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < strs.length; i++)
		{
			temp = strs[i].toCharArray();
			left = 0;
			right = temp.length - 1;
			while(left < right){
				ch = temp[left];
				temp[left] = temp[right];
				temp[right] = ch;
				left++;
				right--;
			}
			sb.append(new String(temp));
			if(i != strs.length - 1){
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
