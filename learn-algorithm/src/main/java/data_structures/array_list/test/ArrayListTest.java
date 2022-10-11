package data_structures.array_list.test;

import data_structures.array_list.ArrayList;
import data_structures.array_list.List;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-10-11
 */
public class ArrayListTest {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("01");
    list.add("02");
    list.add("03");
    list.add("04");
    list.add("05");
    list.add("06");
    list.add("07");
    list.add("08");
    list.add("09");
    list.add("10");
    list.add("11");
    list.add("12");

    System.out.println(list.toString());
    list.remove(9);
    System.out.println(list.toString());
  }
}
