package com.xp.basics.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReaderDemo.java 缓存输入流
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/19
 **/
public class BufferedReaderDemo {

  public static void main(String[] args) {
    File file = new File("D:\\user\\code\\file\\file.txt");
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {

    }
  }
}