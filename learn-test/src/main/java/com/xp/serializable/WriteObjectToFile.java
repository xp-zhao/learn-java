package com.xp.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @description: 序列化测试
 * @author: zhaoxiaoping
 * @create: 2019/06/19
 **/
public class WriteObjectToFile {

  public static void main(String[] args) {
    // 初始化对象
    Student student = new Student();
    student.setName("xp");
    student.setAge(24);
    System.out.println(student);

    // 将对象写到文件中
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializable"))) {
      oos.writeObject(student);
    } catch (IOException e) {
      e.printStackTrace();
    }

    Student.pre = "adfsdf";
    // 从文件中读取对象
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializable"))) {
      Student student1 = (Student) ois.readObject();
      System.out.println(student1);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}