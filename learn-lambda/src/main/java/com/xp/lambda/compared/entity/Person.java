package com.xp.lambda.compared.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

/**
 * @description: 测试 model
 * @author: zhaoxp
 * @create: 2019/04/28
 **/
@Builder
@Data
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public static void main(String[] args) {
        Person person = Person.builder().build();
        Optional<Person> p = Optional.of(person);
        Optional<String> f = Optional.ofNullable(person.getFirstName());
        Optional<String> l = Optional.ofNullable(person.getLastName());
        String str = f.orElse(l.orElse(null));
    }
}