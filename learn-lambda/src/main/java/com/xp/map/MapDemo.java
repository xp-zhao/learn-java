package com.xp.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by xp-zhao on 2018/12/28.
 */
public class MapDemo {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("1", 1);
    map.put("2", 2);
    map.put("3", 3);
    map.put("4", 4);
    map.put("5", 5);
    map.forEach((k, v) -> System.out.println(k + "=" + v));

    List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
    // 显示单词有几个字母
    words.stream()
        .map(String::length)
        .collect(Collectors.toList())
        .forEach(System.out::println);
    // 显示单词表里面的不同字符
    List<String> chars = words.stream()
        .map(s -> s.split(""))
        .flatMap(Arrays::stream)
        .distinct()
        .collect(Collectors.toList());
    System.out.println(chars);
  }
}
