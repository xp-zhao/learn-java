package com.xp.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * MapChangeDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/12
 **/
public class MapChangeDemo {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>(2);
    map.put("xp", 1);
    map.put("xp2", 2);
    String str = "xp xp2";
    System.out.println(
        Arrays.stream(str.split(" ")).map(item -> String.valueOf(map.get(item))).collect(Collectors.joining(",")));

  }
}