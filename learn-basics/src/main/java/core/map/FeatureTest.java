package core.map;

import cn.hutool.core.util.ObjectUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxiaoping
 * @Description: map 新特性测试
 * @Date 2021-3-12
 **/
public class FeatureTest {

  public static void main(String[] args) {
    Map<String, List<String>> map = new HashMap<>();
    // 对 map 处理，不管 key 是否存在。并将结果放入 map 中
    map.compute("ke1", (k, v) -> {
      if (ObjectUtil.isNull(v)) {
        return new ArrayList<>();
      }
      return v;
    });
    System.out.println(map);
    // 当 key 不存在时进行处理。存在时直接返回 value
    map.computeIfAbsent("key1", v -> new LinkedList<>()).add("value1");
    map.computeIfAbsent("key1", v -> new LinkedList<>()).add("value2");
    map.computeIfAbsent("key2", v -> new LinkedList<>()).add("value3");
    System.out.println(map);
    // 当 key 存在时进先处理。key 不存在时返回 null
    map.computeIfPresent("key5", (k, v) -> {
      if (v.size() > 1) {
        v.clear();
      }
      return v;
    });
    System.out.println(map);
  }
}
