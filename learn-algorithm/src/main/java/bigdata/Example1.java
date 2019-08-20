package bigdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 * Example1.java 示例
 * 有2个txt文件，每个文件包含2.5亿个随机的不重复正整数，每个整数占据一行，内存限制为4M，请编写程序实现如下功能：
 * 1.获取这两个文件中重复的正整数；
 * 2.将获取重复的数值里按从大到小排序的前100个数，确保不会出现内存溢出（有可能重复的正整数大小会超过4M）
 * 3.返回的数值形成字符串，用英文,隔开
 * </pre>
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/19
 **/
public class Example1 {

  public static void main(String[] args) throws IOException {
    // 初始化 1000000 的数据
//    init(1000000);
    // 将各个大文件切割成小文件
//    cutFile("D:\\user\\code\\file\\bigdata\\example1\\file1.txt", "D:\\user\\code\\file\\bigdata\\example1\\file1");
//    cutFile("D:\\user\\code\\file\\bigdata\\example1\\file2.txt", "D:\\user\\code\\file\\bigdata\\example1\\file2");
    // 找到重复的数据，保存到 repeat.txt 中
//    findRepeat("D:\\user\\code\\file\\bigdata\\example1\\repeat.txt");
    // 构造堆
    Heap heap = new Heap(100);
    File file = new File("D:\\user\\code\\file\\bigdata\\example1\\repeat.txt");
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream(file)))) {
      String line;
      while ((line = reader.readLine()) != null) {
        heap.insert(Integer.valueOf(line));
      }
    } catch (IOException e) {
    }
    String str = Arrays.stream(heap.arr).filter(item -> item > 0)
        .mapToObj(item -> String.valueOf(item)).collect(Collectors.joining(","));
    System.out.println(str);
  }

  /**
   * 切割大文件
   */
  private static void cutFile(String path, String target) throws FileNotFoundException {
    File file = new File(path);
    File file1 = new File(target);
    file1.mkdirs();
    // 将一个文件切割成 100 个小文件
    BufferedWriter[] writers = new BufferedWriter[100];
    for (int i = 0; i < writers.length; i++) {
      File item = new File(file1.getAbsolutePath() + File.separator + "a" + i + ".txt");
      writers[i] = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(item)));
    }
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream(file)))) {
      String line;
      while ((line = reader.readLine()) != null) {
        writers[Integer.valueOf(line) % 100].write(line + "\n");
      }
    } catch (Exception e) {

    }
  }

  /**
   * 从各个小文件中找到重复的数据
   */
  private static void findRepeat(String path) throws IOException {
    File file = new File(path);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
    int count = 0;
    for (int i = 0; i < 100; i++) {
      Set<String> set = new HashSet<>();
      File file1 = new File("D:\\user\\code\\file\\bigdata\\file1\\example1\\a" + i + ".txt");
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(new FileInputStream(file1)))) {
        String line;
        while ((line = reader.readLine()) != null) {
          set.add(line);
        }
      } catch (IOException e) {

      }
      File file2 = new File("D:\\user\\code\\file\\bigdata\\file2\\a" + i + ".txt");
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(new FileInputStream(file2)))) {
        String line;
        while ((line = reader.readLine()) != null) {
          if (set.contains(line)) {
            bw.write(line + "\n");
            count++;
          }
        }
      } catch (IOException e) {

      }
    }
    bw.close();
    System.out.printf("重复的数据有 %s 条", count);
  }

  /**
   * 初始化数据
   */
  private static void init(int num) {
    File file1 = new File("D:\\user\\code\\file\\bigdata\\file1.txt");
    File file2 = new File("D:\\user\\code\\file\\bigdata\\file2.txt");
    try (BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(file1)));
        BufferedWriter writer1 = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(file2)))) {
      for (int i = 0; i < num; i++) {
        Random random = new Random();
        int anInt = random.nextInt(1000000);
        writer.write(anInt + "\n");
        int anInt1 = random.nextInt(1000000);
        writer1.write(anInt1 + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 小顶堆
   */
  static class Heap {

    private int[] arr;
    private int n;
    private int count;

    public Heap(int capacity) {
      // 从下标 1 开始存储数据
      arr = new int[capacity + 1];
      n = capacity;
      count = 0;
    }

    public void insert(int data) {
      if (count < n) {
        count++;
        arr[count] = data;
        int i = count;
        // 从下往上堆化
        while (i / 2 > 0 && arr[i] < arr[i / 2]) {
          swap(arr, i, i / 2);
          i = i / 2;
        }
        return;
      }
      if (data < arr[1]) {
        return;
      } else {
        arr[1] = data;
        heapify(arr, count, 1);
      }
    }

    private void heapify(int[] array, int n, int i) {
      while (true) {
        int minPos = i;
        if (i * 2 <= n && array[i] > array[i * 2]) {
          minPos = i * 2;
        }
        if (i * 2 + 1 <= n && array[minPos] > array[i * 2 + 1]) {
          minPos = i * 2 + 1;
        }
        if (minPos == i) {
          return;
        }
        swap(array, i, minPos);
        i = minPos;
      }
    }

    /**
     * 交换位置
     */
    private void swap(int[] array, int i, int j) {
      int tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
    }
  }
}