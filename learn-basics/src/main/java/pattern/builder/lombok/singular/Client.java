package pattern.builder.lombok.singular;

import java.util.Arrays;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class Client {

  public static void main(String[] args) {
    Person person = Person.builder()
        .givenName("Aaron")
        .additionalName("A")
        .familyName("Aardvark")
        .tags(Arrays.asList("fictional","incidental"))
        .oneTag("sport")
        .build();
    System.out.println(person);
  }
}