package KMP;

import java.util.Arrays;

/**
 * Created by xp-zhao on 2018/12/26.
 */
public class KMPDemo {

  public static void main(String[] args) {
    String target = "ababababca";
    String pattern = "abababca";

    int[] next = getNext(pattern.toCharArray());
    System.out.println(Arrays.toString(next));
    System.out.println(indexOf(target, pattern));

    int[] next1 = initNext(pattern);
    System.out.println(Arrays.toString(next1));
    System.out.println(match(target, pattern));
    System.out.println(matchKMP(target, pattern, next1));
  }

  /**
   * @Description: 普通的匹配算法，当出现不匹配的字符时，从第二个字符开始重新匹配
   * @Param:
   * @return:
   * @Author: zhaoxp
   * @Date: 2019/5/9
   */
  public static int match(String target, String pattern) {
    char[] targetArray = target.toCharArray();
    char[] patternArray = pattern.toCharArray();
    int targetLength = target.length();
    int patternLength = pattern.length();
    int targetIndex = 0;
    int patternIndex = 0;
    while (targetIndex < targetLength && patternIndex < patternLength) {
      if (targetArray[targetIndex] == patternArray[patternIndex]) {
        // 匹配成功时，下标都往后移
        targetIndex++;
        patternIndex++;
      } else {
        // 出现不匹配的字符时，匹配字符串下标从零开始，目标字符串从第二位字符开始匹配
        targetIndex -= patternIndex - 1;// tagetIndex = tagetIndex - patternIndex + 1;
        patternIndex = 0;
      }
    }
    if (patternIndex == patternLength) {
      // 匹配成功，返回成功匹配时的开始下标
      return targetIndex - patternLength;
    }
    return -1;
  }

  /**
   * @Description: KMP 算法
   * @Param:
   * @return:
   * @Author: zhaoxp
   * @Date: 2019/5/9
   */
  public static int matchKMP(String target, String pattern, int[] next) {
    char[] targetArray = target.toCharArray();
    char[] patternArray = pattern.toCharArray();
    int targetLength = target.length();
    int patternLength = pattern.length();
    int targetIndex = 0;
    int patternIndex = 0;
    while (targetIndex < targetLength && patternIndex < patternLength) {
      if (patternIndex == -1 || (targetArray[targetIndex] == patternArray[patternIndex])) {
        // 匹配成功时，下标都往后移
        targetIndex++;
        patternIndex++;
      } else {
        // 出现不匹配的字符时，目标字符串下标不动，从 next 数组中获取匹配字符串的下标
        patternIndex = next[patternIndex];
      }
    }
    if (patternIndex == patternLength) {
      // 匹配成功，返回成功匹配时的开始下标
      return targetIndex - patternLength;
    }
    return -1;
  }

  /**
   * 生成部分匹配表
   */
  public static int[] initNext(String pattern) {
    char[] patternArray = pattern.toCharArray();
    int len = patternArray.length;
    int[] next = new int[len];
    next[0] = -1;
    int k = -1, j = 0;
    while (j < len - 1) {
			if(k == -1 || (patternArray[j] == patternArray[k])){
			  k++;
			  j++;
			  next[j] = k;
      }else{
			  k = next[k];
      }
    }
    return next;
  }

  /**
   * 获取KMP算法中pattern字符串对应的next数组
   *
   * @param p
   *            模式字符串对应的字符数组
   * @return
   */
  protected static int[] getNext(char[] p) {
    // 已知next[j] = k,利用递归的思想求出next[j+1]的值
    // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
    // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
    // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
    // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
    int pLen = p.length;
    int[] next = new int[pLen];
    int k = -1;
    int j = 0;
    next[0] = -1; // next数组中next[0]为-1
    while (j < pLen - 1) {
      if (k == -1 || p[j] == p[k]) {
        k++;
        j++;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }

  public static int indexOf(String source, String pattern) {
    int i = 0, j = 0;
    char[] src = source.toCharArray();
    char[] ptn = pattern.toCharArray();
    int sLen = src.length;
    int pLen = ptn.length;
    int[] next = getNext(ptn);
    while (i < sLen && j < pLen) {
      // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
      if (j == -1 || src[i] == ptn[j]) {
        i++;
        j++;
      } else {
        // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
        j = next[j];
      }
    }
    if (j == pLen)
      return i - j;
    return -1;
  }
}
