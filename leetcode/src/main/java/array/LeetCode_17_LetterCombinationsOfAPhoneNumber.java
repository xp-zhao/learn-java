package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * 示例:
 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Created by xp-zhao on 2019/1/18.
 */
public class LeetCode_17_LetterCombinationsOfAPhoneNumber
{
	public static void main(String[] args) {
		String digits = "234";
		System.out.println(letterCombinations(digits));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if(digits.length() == 0){
			return list;
		}
		Map<Character, String> map = new HashMap<>();
		map.put('2' , "abc");
		map.put('3' , "def");
		map.put('4' , "ghi");
		map.put('5' , "jkl");
		map.put('6' , "mno");
		map.put('7' , "pqrs");
		map.put('8' , "tuv");
		map.put('9' , "wxyz");
		String[] strs = new String[digits.length()];
		for(int i = 0; i < digits.length(); i++){
			strs[i] = map.get(digits.charAt(i));
		}
		list = getString(strs , 0 , list , "");
		return list;
	}

	private static List<String> getString(String[] str, int i, List<String> result, String temp){
		if(i >= str.length - 1){
			for(int j = 0; j < str[i].length(); j++){
				result.add(temp + str[i].charAt(j));
			}
		}else{
			for(int j = 0; j < str[i].length(); j++){
				result = getString(str, i + 1, result,temp + str[i].charAt(j));
			}
			i++;
		}
		return result;
	}
}
