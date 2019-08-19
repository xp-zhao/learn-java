package com.xp.basics.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutStreamDemo.java 文件输出流（字节流）
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/19
 **/
public class FileOutStreamDemo {

  public static void main(String[] args) throws IOException {
    File file = new File("D:\\user\\code\\file\\fos.txt");
    // 目录不存在则创建目录
    if (!file.exists()) {
      file.getParentFile().mkdirs();
    }
    FileOutputStream fos = new FileOutputStream(file);
    byte[] data = {88, 89};
    fos.write(data);
    fos.close();
    System.out.println(file.length());
  }
}