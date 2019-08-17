package com.xp.bit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 有2个txt文件，每个文件包含2.5亿个随机的不重复正整数，每个整数占据一行，内存限制为4M，请编写程序实现如下功能：
 * <ul>
 * <li>1.	获取这两个文件中重复的正整数；</li>
 * <li>2.	将获取重复的数值里按从大到小排序的前100个数，确保不会出现内存溢出（有可能重复的正整数大小会超过4M）。</li>
 * <li>3.   返回的数值形成字符串，用英文,隔开</li>
 * </ul>
 */
public class Test3Executor {

  /**
   * 程序主入口
   *
   * @param filePath1 第一个文件路径
   * @param filePath2 第二个文件路径
   */
  public static String execute(String filePath1, String filePath2) throws IOException {
    cutFile(filePath1, "D:\\user\\code\\file\\a");
    cutFile(filePath2, "D:\\user\\code\\file\\b");
    // 存放重复的数据
    String path = "D:\\user\\code\\file\\repeat.txt";
    File file = new File(path);
    findRepeat(file);
    return null;
  }

  public static void main(String[] args) throws IOException {
    String file1 = "D:\\user\\code\\file\\file1.txt";
    String file2 = "D:\\user\\code\\file\\file2.txt";
    execute(file1, file2);
  }

  public static void initData() {
    File file = new File("D:\\user\\code\\file\\file2.txt");
    try (BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(file), "utf-8"))) {
      for (int i = 0; i < 10000; i++) {
        int num = new Random().nextInt(10000);
        writer.write(num + "\n");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void cutFile(String source, String target) throws IOException {
    File file1 = new File(source);
    BufferedWriter[] writers = new BufferedWriter[10];
    for (int i = 0; i < writers.length; i++) {
      StringBuilder path = new StringBuilder(target);
      path.append(i + 1).append(".txt");
      File file = new File(path.toString());
      if (!file.exists()) {
        file.createNewFile();
      }
      writers[i] = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
    }
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream(file1)))) {
      String line;
      while ((line = reader.readLine()) != null) {
        writers[line.hashCode() % 10].write(line + "\n");
        writers[line.hashCode() % 10].flush();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void findRepeat(File repeatFile) {
    for (int i = 0; i < 10; i++) {
      Set<String> set = new HashSet<>();
      File file = new File("D:\\user\\code\\file\\a" + i + ".txt");
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(new FileInputStream(file), "utf-8"))) {
        String line;
        while ((line = reader.readLine()) != null) {
          set.add(line);
        }
      } catch (Exception e) {
      }

      File fileB1 = new File("D:\\user\\code\\file\\b" + i + ".txt");
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(new FileInputStream(fileB1), "utf-8"))) {
        String line;
        while ((line = reader.readLine()) != null) {
          if (set.contains(line)) {
            BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(repeatFile, true)));
            bw.write(line + "\n");
            bw.flush();
          }
        }
      } catch (Exception e) {
      }
    }
  }
}
