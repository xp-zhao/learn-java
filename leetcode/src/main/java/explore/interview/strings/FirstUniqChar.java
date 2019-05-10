package explore.interview.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 字符串中第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例: s = "leetcode" 返回 0.
 *
 * s = "loveleetcode", 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 * @author: zhaoxp
 * @create: 2019/05/10
 **/
public class FirstUniqChar {

  public static void main(String[] args) {
    String str = "cc";
    System.out.println(firstUniqChar(str));
    System.out.println(firstUniqChar1(str));
    String str1 = "loveleetcode";
    System.out.println(firstUniqChar(str1));
    System.out.println(firstUniqChar1(str1));
  }

  /**
  * @Description: 个人解法，通过一个有序的 map 记录每个字母的下标，
   *  有重复的字母，则将对应的下标修改为 -1，第一个不为 -1 字母就是第一个唯一字符（效率较低）
  * @Param:
  * @return:
  * @Author: zhaoxp
  * @Date: 2019/5/10
  */
  public static int firstUniqChar(String s) {
    char[] ch = s.toCharArray();
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < ch.length; i++) {
      if(map.keySet().contains(ch[i])){
        map.put(ch[i], -1);
      }else{
        map.put(ch[i], i);
      }
    }
    for (Integer value : map.values()) {
      if(value >= 0){
        return value;
      }
    }
    return -1;
  }

  /** 
  * @Description: 网上的解法，通过一个数字记录每个字符出现的次数
   * 然后顺序判断字符串中每个字符出现的次数，为 1 的就是第一个唯一的字符
  * @Param:  
  * @return:  
  * @Author: zhaoxp
  * @Date: 2019/5/10 
  */
  public static int firstUniqChar1(String s){
    int[] index = new int[26];
    for (int i = 0; i < s.length(); i++) {
      int idx = s.charAt(i) - 'a';
      index[idx]++;
    }
    for (int i = 0; i < s.length(); i++) {
      int idx = s.charAt(i) - 'a';
      if(index[idx] == 1){
        return i;
      }
    }
    return -1;
  }
}