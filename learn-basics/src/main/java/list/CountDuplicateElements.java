package list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * CountDuplicateElements.java  how to count duplicate elements in Arraylist
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class CountDuplicateElements {

  public static void main(String[] args) {
    List<String> list = Arrays.asList(
        "expect1",
        "expect2", "expect2",
        "expect3", "expect3", "expect3",
        "expect4", "expect4", "expect4", "expect4");
    Map<String, Long> map1 = countByClassicalLoop(list);
    map1.forEach((k, v) -> {
      System.out.println(k + ":" + v);
    });
    System.out.println("##########################");
    Map<String, Long> map2 = countByClassicalLoopMapCompute(list);
    map2.forEach((k, v) -> {
      System.out.println(k + ":" + v);
    });
  }

  /**
   * loop with map.put()
   */
  public static <T> Map<T, Long> countByClassicalLoop(List<T> list) {
    Map<T, Long> resultMap = new HashMap<>();
    for (T item : list) {
      if (resultMap.containsKey(item)) {
        resultMap.put(item, resultMap.get(item) + 1L);
      } else {
        resultMap.put(item, 1L);
      }
    }
    return resultMap;
  }

  /**
   * loop with map.compute()
   */
  public static <T> Map<T, Long> countByClassicalLoopMapCompute(List<T> list) {
    Map<T, Long> resultMap = new HashMap<>();
    for (T item : list) {
      resultMap.compute(item, (k, v) -> v == null ? 1 : v + 1L);
    }
    return resultMap;
  }

  /**
   * Stream API Collectors.toMap()
   */
  public static <T> Map<T, Long> countByStreamToMap(List<T> list) {
    return list.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
  }

  public static <T> Map<T, Long> countByStreamGroupBy(List<T> list) {
//    return list.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

}