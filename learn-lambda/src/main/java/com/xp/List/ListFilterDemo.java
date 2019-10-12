package com.xp.List;

import java.util.Arrays;
import java.util.List;

/**
 * ListFilterDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/12
 **/
public class ListFilterDemo {

  public static void main(String[] args) {
    List<Integer> id1 = Arrays.asList(1, 2, 3);
    List<Integer> id2 = Arrays.asList(4, 5, 6);
    List<Integer> id = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    id.stream().filter(item -> !id1.contains(item)).filter(item -> !id2.contains(item))
        .forEach(System.out::println);
  }
}