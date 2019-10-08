package com.xp.hutool;

import cn.hutool.core.util.ReUtil;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ReUtilDemo.java 正则表达式示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/30
 **/
public class ReUtilDemo {

  public static void main(String[] args) {
    System.out.println(ReUtil.isMatch("\\d", "2"));
    String str = "2019年10月1日";
    System.out.println(ReUtil.findAll("\\d+", str, 0));
    List<String> list = Arrays.asList("A出版社 B出版社", "C出版社", "KSSR");
    List<String> result = list.stream()
        .filter(item -> item.split(" ").length > 1)
        .collect(Collectors.toList());
    System.out.println(result);
  }
}