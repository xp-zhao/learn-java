package com.xp.pinyin;

import java.util.ArrayList;
import java.util.List;
import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * PinYinDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/09
 **/
public class PinYinDemo {

  public static void main(String[] args) {
    String string = "这是我的祖国";
    char[] ch = string.toCharArray();
    for (char c : ch) {
      String[] str = PinyinHelper.toHanyuPinyinStringArray(c);
      List<String> list = new ArrayList<>();
      for (String s : str) {
        list.add(s);
      }
      System.out.println(list);
    }

  }
}