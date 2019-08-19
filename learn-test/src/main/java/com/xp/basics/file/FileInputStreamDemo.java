package com.xp.basics.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputStreamDemo.java 输入流(字节流)
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/19
 **/
public class FileInputStreamDemo {

  public static void main(String[] args) throws IOException {
    File file = new File("D:\\user\\code\\file\\file.txt");
    FileInputStream fis = new FileInputStream(file);
    byte[] all = new byte[(int) file.length()];
    fis.read(all);
    for (byte b : all) {
      System.out.println(b);
    }
    fis.close();
  }
}