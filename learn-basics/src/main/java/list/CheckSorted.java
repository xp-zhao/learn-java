package list;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/**
 * CheckSorted.java Checking If a List is Sorted
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class CheckSorted {

  public static void main(String[] args) {

  }

  /**
   * using comparable
   */
  public static boolean isSorted(List<String> list) {
    if (CollectionUtils.isEmpty(list) || list.size() == 1) {
      return true;
    }
    Iterator<String> iterator = list.iterator();
    String current = iterator.next();
    String previous = current;
    while (iterator.hasNext()) {
      current = iterator.next();
      if (previous.compareTo(current) > 0) {
        return false;
      }
      previous = current;
    }
    return true;
  }

  /**
   * using comparator
   */
  public static boolean isSorted(List<Employee> list, Comparator<Employee> employeeComparator) {
    if (CollectionUtils.isEmpty(list) || list.size() == 1) {
      return true;
    }
    Iterator<Employee> iterator = list.iterator();
    Employee current = iterator.next();
    Employee previous = current;
    while (iterator.hasNext()) {
      current = iterator.next();
      if (employeeComparator.compare(previous, current) > 0) {
        return false;
      }
      previous = current;
    }
    return true;
  }
}