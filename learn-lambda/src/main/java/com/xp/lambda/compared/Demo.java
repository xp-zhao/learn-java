package com.xp.lambda.compared;

import com.xp.lambda.compared.entity.Person;
import java.util.Arrays;
import java.util.List;

/**
 * Demo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/08
 **/
public class Demo {

  public static void main(String[] args) {
    List<Person> personList = Arrays
        .asList(Person.builder().firstName("xp").lastName("zhao2").build(),
            Person.builder().firstName("xp1").lastName("zhao1").build());
    System.out.println(personList);
    personList.stream().forEach(item -> item.setAge(1));
    System.out.println(personList);
  }
}