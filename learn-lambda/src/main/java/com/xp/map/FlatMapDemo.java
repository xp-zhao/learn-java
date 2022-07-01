package com.xp.map;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * FlatMapDemo.java flatMap 使用示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/27
 */
public class FlatMapDemo {

  public static void main(String[] args) {
    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
    List<String> list = Arrays.asList("my name is 007", "this is test");

    list.stream()
        .map(item -> item.split(" "))
        .flatMap(Arrays::stream)
        .distinct()
        .forEach(System.out::println);
  }
}
