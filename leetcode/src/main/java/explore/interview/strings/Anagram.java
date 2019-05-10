package explore.interview.strings;

/**
 * @description: 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *
 * 示例 2: 输入: s = "rat", t = "car" 输出: false 说明: 你可以假设字符串只包含小写字母。
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @author: zhaoxp
 * @create: 2019/05/10
 **/
public class Anagram {

  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    System.out.println(isAnagram(s, t));
    System.out.println(isAnagram1(s, t));
    String s1 = "rat";
    String t1 = "car";
    System.out.println(isAnagram(s1, t1));
    System.out.println(isAnagram1(s1, t1));
  }

  /**
   * @Description: 个人解法
   * @Param:
   * @return:
   * @Author: zhaoxp
   * @Date: 2019/5/10
   */
  public static boolean isAnagram(String s, String t) {
    int[] sChars = new int[26];
    int[] tChars = new int[26];
    for (int i = 0; i < s.length(); i++) {
      sChars[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      tChars[t.charAt(i) - 'a']++;
    }
    for (int i = 0; i < sChars.length; i++) {
      if (sChars[i] != tChars[i]) {
        return false;
      }
    }
    return true;
  }

  /** 
  * @Description: 优化解法
  * @Param:  
  * @return:  
  * @Author: zhaoxp
  * @Date: 2019/5/10 
  */
  public static boolean isAnagram1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] arr = new int[26];
    for (char c : s.toCharArray()) {
      arr[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      if (arr[c - 'a'] == 0) {
        return false;
      }
      arr[c - 'a']--;
    }
    return true;
  }
}