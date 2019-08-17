package com.xp.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/09
 **/
public class Demo {

  public static void main(String[] args) {
    Integer num = 1000000000;
    List<Integer> ids = Arrays.asList(1, 2, 3, 4);
    String str = ids.stream()
        .map(item -> String.valueOf(item))
        .collect(Collectors.joining(","));
    System.out.println(str);

    String nodeId = "RJB_SX_KBZSD_1";
    System.out.println(nodeId.hashCode());
    System.out.println(nodeId.split("_")[1]);

    for (String s : "".split(":;")) {
      System.out.println("s:"+s);
    }
  }
}