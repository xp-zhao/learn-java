package list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * CheckSortedTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class CheckSortedTest {

  private List<String> list;
  private List<Employee> employees;

  @Before
  public void init() {
    list = Arrays.asList("a", "b", "c", "d");
    employees = Arrays.asList(Employee.builder().id(1L).build(), Employee.builder().id(2L).build());
  }

  @Test
  public void testComparable() {
    boolean flag = CheckSorted.isSorted(list);
    Assert.assertTrue(flag);
  }

  @Test
  public void testComparator() {
    Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getId);
    boolean flag = CheckSorted.isSorted(employees, employeeComparator);
    Assert.assertTrue(flag);
  }

}