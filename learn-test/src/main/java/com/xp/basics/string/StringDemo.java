package com.xp.basics.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

/**
 * StringDemo.java String 学习
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/27
 **/
public class StringDemo {

  public static void main(String[] args) {
    // 占位符
    String c = "create (n{section:'%s' ,name:'%s', age: %s}) return id(n)";
    System.out.println(String.format(c, "小学", "测试", 10));
    String cql = "match (n) where id(n) = %s set %s return n";
    Map<String, String> param = new HashMap<>();
    param.put("node_id", "test");
    param.put("name", "name");
    List<String> strs = new ArrayList<>();
    for (Entry<String, String> entry : param.entrySet()) {
      StringBuilder sb = new StringBuilder();
      sb.append("n.").append(entry.getKey()).append("='").append(entry.getValue()).append("'");
      strs.add(sb.toString());
    }
    String set = String.join(",", strs);
    System.out.println(String.format(cql, 10, set));
    String s = new String("1");
    s.intern();
    String s2 = "1";
    System.out.println(s == s2);

    String s3 = new String("1") + new String("1");
    s3.intern();
    String s4 = "11";
    System.out.println(s3 == s4);

    /**
     * StringJoiner 拼接字符串
     */
    StringJoiner sj = new StringJoiner(":");
    sj.add("cd");
    sj.add("ef");
    System.out.println(sj.toString());

    StringJoiner sj1 = new StringJoiner(":", "[", "]");
    sj1.add("a");
    sj1.add("b");
    sj1.add("c");
    System.out.println(sj1.toString());
  }
}