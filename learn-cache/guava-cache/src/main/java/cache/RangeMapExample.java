package cache;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * 范围 Map 使用示例
 *
 * @author zhaoxiaoping
 * @date 2022-5-13
 */
public class RangeMapExample {
  public static void main(String[] args) {
    RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
    rangeMap.put(Range.closedOpen(0, 60), "fail");
    rangeMap.put(Range.closed(60, 90), "satisfactory");
    rangeMap.put(Range.openClosed(90, 100), "excellent");

    System.out.println(rangeMap.get(59));
    System.out.println(rangeMap.get(60));
    System.out.println(rangeMap.get(90));
    System.out.println(rangeMap.get(91));
  }
}
