package com.xp.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * StreamDemo.java stream 测试
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/27
 **/
public class StreamDemo {

  public static void main(String[] args) {
    String str = "my name is 007";
    // 打印每个单词的长度
    Stream.of(str.split(" "))
        .filter(s -> s.length() > 2)
        .map(s -> s.length())
        .forEach(System.out::println);

    // 打印每个单词
    Stream.of(str.split(" "))
        .flatMap(s -> s.chars().boxed())
        .forEach(i -> System.out.println((char)i.intValue()));

    System.out.println("--------------peek------------");
    Stream.of(str.split(" "))
        .peek(System.out::println)
        .forEach(System.out::println);

    // 使用 limit ，创建无限流
    new Random().ints()
        .filter(i -> i > 100 && i < 1000)
        .limit(10)
        .forEach(System.out::println);

    // 使用 reduce 拼接字符串
    String str1 = Stream.of(str.split(" "))
        .reduce("test", (s1, s2) -> s1 + "|" + s2);
    System.out.println(str1);
    String str2 = Stream.of(str.split(" "))
        .reduce((s1, s2) -> s1 + "|" + s2)
        .orElse("");
    System.out.println(str2);
  }
}