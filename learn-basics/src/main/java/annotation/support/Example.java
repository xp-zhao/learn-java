package annotation.support;

import annotation.value.Employee;
import java.util.Arrays;
import java.util.List;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-7-28
 */
public class Example {
  public static void main(String[] args) {
    Employee user1 = new Employee();
    Employee user2 = new Employee();
    user1.setId(1);
    user2.setId(1);
    List<Employee> list = Arrays.asList(user1, user2);
    UserInfoSupport.setUserInfo(list);
    System.out.println(user1);
    System.out.println(user2);
  }
}
