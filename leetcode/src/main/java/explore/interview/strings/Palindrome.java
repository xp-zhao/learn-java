package explore.interview.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 验证回文字符串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * @author: zhaoxp
 * @create: 2019/05/10
 **/
public class Palindrome {

  public static void main(String[] args) {
    String s1 = "A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(s1));
    String s2 = "race a car";
    System.out.println(isPalindrome(s2));
  }

  public static boolean isPalindrome(String s) {
    if(s.trim().equals("")){
      return true;
    }
    List<Character> ch = new ArrayList<>();
    for (char c : s.toLowerCase().trim().toCharArray()) {
      if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
        ch.add(c);
      }
    }
    if(ch.size() == 1){
      return false;
    }
    int left = 0;
    int right = ch.size() - 1;
    while (left < right){
      if(ch.get(left) != ch.get(right)){
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}