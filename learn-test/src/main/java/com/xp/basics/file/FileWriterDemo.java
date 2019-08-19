package com.xp.basics.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriterDemo.java 字符输出流
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/19
 **/
public class FileWriterDemo {

  public static void main(String[] args) {
    File file = new File("D:\\user\\code\\file\\fw.txt");
    if(!file.exists()){
      file.getParentFile().mkdirs();
    }
    try(FileWriter writer = new FileWriter(file)) {
      String str = "abcdefg1234567890";
      char[] data = str.toCharArray();
      writer.write(data);
    } catch (IOException e){

    }
  }
}