package com.xp.basics.file;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * FileDemo.java 文件对象
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/19
 **/
public class FileDemo {

  public static void main(String[] args) {
    File file1 = new File("D:\\user\\code\\file");
    System.out.println("file1 的绝对路径：" + file1.getAbsolutePath());
    File file2 = new File("file.txt");
    System.out.println("file2 的绝对路径：" + file2.getAbsolutePath());
    File file3 = new File(file1, "file.txt");
    System.out.println("file3 的绝对路径：" + file3.getAbsolutePath());
    // 常用方法
    File f = new File("D:\\user\\code\\file\\repeat.txt");
    System.out.println("当前文件是：" + f);
    // 文件是否存在
    System.out.println("文件是否存在：" + f.exists());
    // 是否是文件夹
    System.out.println("是否是文件夹：" + f.isDirectory());
    // 是否是文件
    System.out.println("是否是文件：" + f.isFile());
    // 文件长度
    System.out.println("文件长度：" + f.length());
    // 文件最后修改时间
    Instant instant = Instant.ofEpochMilli(f.lastModified());
    System.out.println("文件最后修改时间：" + LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
    // 文件重命名
    File f2 = new File("D:\\user\\code\\file\\repeat1.txt");
    f.renameTo(f2);
    File f3 = new File("D:\\user\\code\\file");
    for (String s : f3.list()) {
      System.out.println(s);
    }
  }
}