package list;

import java.util.Arrays;
import java.util.List;

/**
 * FilterList.java Filtering a Java Colletion by a List
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class FilterList {

  public static void main(String[] args) {

  }

  public static List<Employee> buildEmployeeList() {
    return Arrays.asList(
        new Employee(1, "Mike"),
        new Employee(2, "John"),
        new Employee(3, "Mary"),
        new Employee(4, "Joe"),
        new Employee(5, "Nicole"),
        new Employee(6, "Alice"),
        new Employee(7, "Bob"),
        new Employee(8, "Scarlett"));
  }

  public static List<String> employeeNameFilter() {
    return Arrays.asList("Alice", "Mike", "Bob");
  }
}