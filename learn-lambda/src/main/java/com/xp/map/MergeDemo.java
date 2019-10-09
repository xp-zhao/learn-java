package com.xp.map;

import com.xp.map.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ch113
 */
public class MergeDemo {
    public static void main(String[] args) {
        List<Student> students = build();
        // 计算每个学生的总成绩
        // 方法一
        firstMethod(students);
        // 方法二
        secondMethod(students);
    }

    private static void secondMethod(List<Student> students) {
        Map<String, Float> studentMap = new HashMap<>();
        students.forEach(student -> studentMap.merge(
                student.getName(),
                student.getScore(),
                Float::sum
        ));
        System.out.println(studentMap);
    }

    private static void firstMethod(List<Student> students) {
        Map<String, Float> studentMap = new HashMap<>();
        students.forEach(student -> {
            if (studentMap.containsKey(student.getName())) {
                studentMap.put(student.getName(), studentMap.get(student.getName()) + student.getScore());
            } else {
                studentMap.put(student.getName(), student.getScore());
            }
        });
        System.out.println(studentMap);
    }

    private static List<Student> build() {
        List<Student> students = new ArrayList<>();
        Student student1 = Student.builder().name("张三").subject("语文").score(70).build();
        Student student2 = Student.builder().name("张三").subject("数学").score(80).build();
        Student student3 = Student.builder().name("张三").subject("英语").score(65).build();
        Student student4 = Student.builder().name("李四").subject("语文").score(68).build();
        Student student5 = Student.builder().name("李四").subject("数学").score(70).build();
        Student student6 = Student.builder().name("李四").subject("英语").score(90).build();
        Student student7 = Student.builder().name("王五").subject("语文").score(80).build();
        Student student8 = Student.builder().name("王五").subject("数学").score(85).build();
        Student student9 = Student.builder().name("王五").subject("英语").score(70).build();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        return students;
    }
}
