package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @description: list分页工具
 * @author: zhaoxp
 * @create: 2019/05/31
 **/
public class ListPage {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    System.out.println(pageList(list, 1, 10));
  }

  private static List<Integer> pageList(List<Integer> list, int pageNo, int pageSize) {
    List<Integer> newList = new ArrayList<>();
    if (CollectionUtils.isEmpty(list)) {
      return newList;
    }
    if (pageSize * (pageNo - 1) > list.size()) {
      return newList;
    }
    int fromIndex = (pageNo - 1) * pageSize;
    int toIndex = (pageNo * pageSize) > list.size() ? list.size() : (pageSize * pageNo);
    newList = list.subList(fromIndex, toIndex);
    return newList;
  }
}