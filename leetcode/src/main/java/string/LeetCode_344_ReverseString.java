package string;

/**
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。

 示例 1:
 输入: "hello"
 输出: "olleh"

 示例 2:
 输入: "A man, a plan, a canal: Panama"
 输出: "amanaP :lanac a ,nalp a ,nam A"
 * Created by xp-zhao on 2018/12/6.
 */
public class LeetCode_344_ReverseString
{
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(reverseString(s));
	}

	public static String reverseString(String s) {
		char[] ch = s.toCharArray();
		int left = 0;
		int right = ch.length - 1;
		char temp;
		while(left < right){
			temp = ch[left];
			ch[left] = ch[right];
			ch[right] = temp;
			left++;
			right--;
		}
		return new String(ch);
	}
}
