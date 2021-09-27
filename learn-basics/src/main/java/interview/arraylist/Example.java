package interview.arraylist;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** @author zhaoxiaoping @Description: @Date 2021-9-26 */
public class Example {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>(Collections.nCopies(1, "a"));
    list.add("2");
    System.out.println(list);
    LinkedList<String> linkedList = new LinkedList<String>();
    linkedList.add("a");
    linkedList.add("b");
    linkedList.remove();
    System.out.println(linkedList);
//    System.out.println(getCapacity(list));
  }

  public static void copy() {
    Integer[] srcArray = new Integer[] {1, 2, 3, 4, 5, 6};
    Integer[] destArray = new Integer[3];
    System.arraycopy(srcArray, 0, destArray, 0, 3);
    System.out.println(Arrays.toString(destArray));
  }

  public static Integer getCapacity(ArrayList list) {
    Class<ArrayList> arrayListClass = ArrayList.class;
    try {
      Field field = arrayListClass.getDeclaredField("elementData");
      field.setAccessible(true);
      Object[] o = (Object[]) field.get(list);
      return o.length;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }
}
