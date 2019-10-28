package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

/**
 * FilterListTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class FilterListTest {

  @Test
  public void testForEachLoop() {
    List<Employee> filteredList = new ArrayList<>();
    List<Employee> originalList = FilterList.buildEmployeeList();
    List<String> nameFilter = FilterList.employeeNameFilter();

    for (Employee employee : originalList) {
      for (String name : nameFilter) {
        if (employee.getName().equalsIgnoreCase(name)) {
          filteredList.add(employee);
        }
      }
    }
    Assert.assertTrue(filteredList.size() == nameFilter.size());
  }

  @Test
  public void testLambda() {
    List<Employee> filteredList = new ArrayList<>();
    List<Employee> originalList = FilterList.buildEmployeeList();
    List<String> nameFilter = FilterList.employeeNameFilter();

    filteredList = originalList.stream()
        .filter(item -> nameFilter.contains(item.getName()))
        .collect(Collectors.toList());
    Assert.assertTrue(filteredList.size() == nameFilter.size());
  }

  @Test
  public void testHashSet() {
    List<Employee> filteredList = new ArrayList<>();
    List<Employee> originalList = FilterList.buildEmployeeList();
    Set<String> nameFilter = FilterList.employeeNameFilter().stream().collect(Collectors.toSet());

    filteredList = originalList.stream()
        .filter(item -> nameFilter.contains(item.getName()))
        .collect(Collectors.toList());
    Assert.assertTrue(filteredList.size() == nameFilter.size());
  }

}