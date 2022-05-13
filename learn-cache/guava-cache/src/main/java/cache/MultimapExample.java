package cache;

import com.google.common.collect.ArrayListMultimap;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 多值 Map 使用示例
 *
 * @author zhaoxiaoping
 * @date 2022-5-13
 */
public class MultimapExample {
  public static void main(String[] args) {
    ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
    multimap.put("day", 1);
    multimap.put("day", 2);
    multimap.put("day", 8);
    multimap.put("month", 3);
    List<Integer> day = multimap.get("day");
    List<Integer> month = multimap.get("month");
    System.out.println(day);
    System.out.println(multimap.size());
    System.out.println("修改前: " + multimap);
    day.remove(0);
    month.add(12);
    System.out.println("修改后: " + multimap);
    // 转换为 Map
    Map<String, Collection<Integer>> map = multimap.asMap();
    for (String key : map.keySet()) {
      System.out.println(key + " : " + map.get(key));
    }
    map.get("day").add(20);
    System.out.println(multimap);
    // 数量问题
    System.out.println(multimap.size());
    System.out.println(multimap.entries().size());
    for (Map.Entry<String, Integer> entry : multimap.entries()) {
      System.out.println(entry.getKey() + "," + entry.getValue());
    }
  }
}
