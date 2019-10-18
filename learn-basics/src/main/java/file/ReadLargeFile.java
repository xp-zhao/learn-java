package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * file.ReadLargeFile.java 读取大文件示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/18
 **/
public class ReadLargeFile {

  public static void main(String[] args) throws IOException {
    String path = buildFile();
    scannerRead(path);
    commonsIoRead(path);
  }

  /**
   * Scanner 读取大文件
   *
   * @param path 文件路径
   */
  public static void scannerRead(String path) {
    try (FileInputStream inputStream = new FileInputStream(path);
        Scanner sc = new Scanner(inputStream, "UTF-8")) {
      int i = 0;
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        i++;
      }
      System.out.println(String.format("总行数 %d 行", i));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Apache Common IO 读取大文件
   *
   * @param path 文件路径
   */
  public static void commonsIoRead(String path) {
    File file = new File(path);
    try (LineIterator iterator = FileUtils.lineIterator(file, "UTF-8")) {
      int i = 0;
      while (iterator.hasNext()) {
        String line = iterator.nextLine();
        i++;
      }
      System.out.println(String.format("总行数 %d 行", i));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 构造测试文件
   *
   * @return 文件路径
   * @throws IOException IO 异常
   */
  public static String buildFile() throws IOException {
    File file = new File("largeFile.txt");
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    for (int i = 0; i < 10; i++) {
      writer.write("file" + i + "\n");
    }
    writer.close();
    return file.getAbsolutePath();
  }
}