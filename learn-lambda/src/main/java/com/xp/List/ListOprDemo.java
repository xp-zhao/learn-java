package com.xp.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: lambda集合交集、并集、去重等操作
 * @author: zhaoxp
 * @create: 2019/04/30
 **/
public class ListOprDemo {

  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
    System.out.println("list1:\t"+list1);
    System.out.println("list2:\t"+list2);
    // 求交集
    List<Integer> list3 = list1.stream()
        .filter(item -> list2.contains(item))
        .collect(Collectors.toList());
    System.out.println("交集:\t"+list3);
//    list3.parallelStream().forEach(System.out::println); // 并行操作
    // 求并集
    list1.addAll(list2);
    System.out.println("并集:\t"+list1);
    // 去重并集
    List<Integer> list = list1.stream().distinct().collect(Collectors.toList());
    System.out.println("去重并集:\t"+list);
    // 求差集 list1 - list2
    List<Integer> list4 = list1.stream()
        .filter(item -> !list2.contains(item))
        .collect(Collectors.toList());
    System.out.println("差集(list1 - list2):\t"+list4);
    // 求差集 list2 - list1
    List<Integer> list5 = list2.stream()
        .filter(item -> !list1.contains(item))
        .collect(Collectors.toList());
    System.out.println("差集(list2 - list1):\t"+list5);

  }
}