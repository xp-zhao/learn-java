package com.xp.lambda.compared;

import com.xp.lambda.compared.entity.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Demo.java 根据对象的某些字段对 List 进行去重
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/08
 */
public class CollectionAndThenExample {

  public static void main(String[] args) {
    List<Person> personList =
        Arrays.asList(
            Person.builder().firstName("xp").lastName("zhao2").build(),
            Person.builder().firstName("xp1").lastName("zhao1").age(20).build(),
            Person.builder().firstName("xp1").lastName("zhao3").age(20).build());
    System.out.println(personList);
    // 根据 firstName、age 去重
    List<Person> distinctList =
        personList.stream()
            .collect(
                Collectors.collectingAndThen(
                    Collectors.toCollection(
                        () ->
                            new TreeSet<>(
                                Comparator.comparing(
                                    item -> item.getFirstName() + ":" + item.getAge()))),
                    ArrayList::new));
    System.out.println(distinctList);
  }
}
