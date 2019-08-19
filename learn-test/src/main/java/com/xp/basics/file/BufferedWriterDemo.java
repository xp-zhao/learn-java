package com.xp.basics.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriterDemo.java 缓存输出流
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/19
 **/
public class BufferedWriterDemo {

  public static void main(String[] args) {
    File file = new File("D:\\user\\code\\file\\file.txt");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
      writer.write("CD");
    } catch (IOException e){

    }
  }
}