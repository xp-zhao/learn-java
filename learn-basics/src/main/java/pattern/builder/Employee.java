package pattern.builder;

/**
 * Employee.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
public class Employee {

  private final String name;
  private final int age;
  private final String department;

  private Employee(String name, int age, String department) {
    this.name = name;
    this.age = age;
    this.department = department;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", department='" + department + '\'' +
        '}';
  }

  public static class Builder {

    private String name;
    private int age;
    private String department;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public Builder setDepartment(String department) {
      this.department = department;
      return this;
    }

    public Employee build() {
      return new Employee(name, age, department);
    }
  }
}