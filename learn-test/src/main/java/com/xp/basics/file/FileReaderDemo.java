package com.xp.basics.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileReaderDemo.java 字符输入流
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/19
 **/
public class FileReaderDemo {

  public static void main(String[] args) {
    File file = new File("D:\\user\\code\\file\\file.txt");
    try (FileReader reader = new FileReader(file)) {
      char[] all = new char[(int) file.length()];
      reader.read(all);
      for (char c : all) {
        System.out.println(c);
      }
    } catch (IOException e) {
    }
  }
}