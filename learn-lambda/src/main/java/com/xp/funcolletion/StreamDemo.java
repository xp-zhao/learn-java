package com.xp.funcolletion;

import com.xp.funcolletion.entity.Student;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamDemo.java 常用流的使用示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/16
 **/
public class StreamDemo {

  public static void main(String[] args) {
    /**
     * collect(Collectors.toList()) 的使用
     */
    List<Student> students = Stream
        .of(new Student("xp", 20, 180),
            new Student("xp1", 21, 185),
            new Student("xp2", 22, 175))
        .collect(Collectors.toList());
    System.out.println(students);

    /**
     * filter 的使用
     */
    List<Student> filterList = students.stream()
        .filter(student -> student.getStature() < 180)
        .collect(Collectors.toList());
    System.out.println(filterList);

    /**
     * map 的使用
     */
    List<String> names = students.stream()
//        .map(Student::getName)
        .map(student -> student.getName())
        .collect(Collectors.toList());
    System.out.println(names);

    /**
     * flatMap 的使用 (将多个Stream合并为一个Stream)
     */
    List<Student> studentList = Stream.of(students,
        Arrays.asList(new Student("xp3", 25, 180),
            new Student("xp4", 26, 188)))
        .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
    System.out.println(studentList);

    /**
     * max 和 min 的使用
     */
    students.stream().max(Comparator.comparing(student -> student.getAge()))
        .ifPresent(student -> System.out.println(student.getAge()));
    students.stream().min(Comparator.comparing(Student::getAge))
        .ifPresent(student -> System.out.println(student.getAge()));

    /**
     * count 的使用
     */
    long count = students.stream().filter(student -> student.getAge() < 22).count();
    System.out.println("年龄小于 22 岁的人数：" + count);

    /**
     * reduce 的使用
     */
    Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (acc, x) -> acc + x);
    System.out.println(reduce);
  }
}