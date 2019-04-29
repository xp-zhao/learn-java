package com.xp.lambda.compared;

import com.xp.lambda.compared.entity.Person;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 用户信息打印 demo
 * @author: zhaoxp
 * @create: 2019/04/28
 **/
public class PersonPrintDemo {
    public static void main(String[] args) {
        List<Person> guiltyPersons = Arrays.asList(
                new Person("Yixing", "Zhao", 23),
                new Person("Yanggui", "Li", 30),
                new Person("Chao", "Ma", 29)
        );
        // 打印出 guiltyPersons 中 所有 lastName 以 Z 开头的人的 firstName
        // 1. 原生态 lambda 写法 (需要自定义两个函数式接口 NameChecker、Executor)
        checkAndExecute(guiltyPersons,
                p -> p.getLastName().startsWith("Z"),
                p -> System.out.println(p.getFirstName()));
        // 2. 简洁的写法，使用 java.util.function 中的函数式接口替换自定义的函数式接口
        // NameChecker -> Predicate、Executor -> Consumer
        checkAndExecute(guiltyPersons);
    }

    public static void checkAndExecute(List<Person> personList, NameChecker nameChecker, Executor executor){
        for (Person person : personList) {
            if(nameChecker.check(person)){
                executor.execute(person);
            }
        }
    }

    public static void checkAndExecute(List<Person> personList){
        // 1. 第一步简化，理由函数式接口包 Predicate、Consumer
//        for (Person person : personList) {
//            if(predicate.test(person)){
//                consumer.accept(person);
//            }
//        }
        // 2. 第二部简化，用 Iterable.forEach() 替换 foreach loop
//        personList.forEach(person -> {
//            if (predicate.test(person)) {
//               consumer.accept(person);
//            }
//        });
        // 3. 第三部简化，使用 stream() 替换静态函数
        personList.stream()
                .filter(person -> person.getLastName().startsWith("Z"))
                .forEach(person -> System.out.println(person.getFirstName()));
    }
}