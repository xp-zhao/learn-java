package core.comparision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2023-8-25
 */
@Data
public class Person {
  private int id;
  private int age;

  public Person(int id, int age) {
    this.id = id;
    this.age = age;
  }

  public static void main(String[] args) {
    Person p1 = new Person(1, 20);
    Person p2 = new Person(2, 21);
    Person p3 = new Person(2, 22);
    Person p4 = new Person(3, 20);
    Person p5 = new Person(3, 19);
    Person p6 = new Person(4, 20);
    List<Person> list = Arrays.asList(p1, p2, p3, p4, p5, p6);
    System.out.println(list);
    list.sort(
        Comparator.comparing(Person::getId)
            .thenComparing(Person::getAge, Comparator.reverseOrder()));
    //    list.sort(Comparator.comparing(Person::getId).thenComparing(Person::getAge).reversed());
    System.out.println(list);
  }
}
