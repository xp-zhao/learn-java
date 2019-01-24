package hash;

import java.util.*;

/**
 * 500. 键盘行
 * 示例：
 输入: ["Hello", "Alaska", "Dad", "Peace"]
 输出: ["Alaska", "Dad"]

 注意：
 你可以重复使用键盘上同一字符。
 你可以假设输入的字符串将只包含字母。
 * Created by xp-zhao on 2019/1/24.
 */
public class LeetCode_500_KeyBoardRow
{
	public static void main(String[] args) {
		String[] words = {"Hello" , "Alaska" , "Dad" , "Peace"};
		System.out.println(Arrays.toString(findWords(words)));
	}

	public static String[] findWords(String[] words) {
		String one = "qwertyuiop";
		String two = "asdfghjkl";
		String three = "zxcvbnm";
		Map<Character, Integer> map = new HashMap<>();
		for(char c : one.toCharArray())
		{
			map.put(c , 1);
		}
		for(char c : two.toCharArray())
		{
			map.put(c , 2);
		}
		for(char c : three.toCharArray())
		{
			map.put(c , 3);
		}
		List<String> list = new ArrayList<>();
		for(String word : words)
		{
			char[] chars = word.toCharArray();
			int flag = map.get(Character.toLowerCase(chars[0]));
			for(int i = 1; i < chars.length; i++){
				if(flag != map.get(Character.toLowerCase(chars[i]))){
					flag = -1;
					break;
				}
			}
			if(flag != -1){
				list.add(word);
			}
		}
		String[] result = new String[list.size()];
		for(int i = 0; i < list.size(); i++)
		{
			result[i] = list.get(i);
		}
		return result;
	}
}
