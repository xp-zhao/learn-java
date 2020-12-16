package com.xp.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author zhaoxiaoping
 * @Description: reduce 累加示例
 * @Date 2020-12-1
 **/
public class Reduce {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
    Collector<Object, ?, Integer> reducing = Collectors.reducing(0, i -> 1, Integer::sum);
    System.out.println(list.stream().collect(reducing).intValue());
    System.out.println(list.stream().reduce(Integer::sum));
  }
}
