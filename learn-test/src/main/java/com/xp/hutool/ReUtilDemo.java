package com.xp.hutool;

import cn.hutool.core.util.ReUtil;

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
  }
}