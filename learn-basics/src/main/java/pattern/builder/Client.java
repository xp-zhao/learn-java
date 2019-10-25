package pattern.builder;

import pattern.builder.Employee.Builder;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
public class Client {

  public static void main(String[] args) {
    Employee.Builder builder = new Builder();
    Employee employee = builder
        .setName("xp")
        .setAge(22)
        .setDepartment("test")
        .build();
    System.out.println(employee);
  }
}