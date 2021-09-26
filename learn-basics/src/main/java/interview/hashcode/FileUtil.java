package interview.hashcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/** @author zhaoxiaoping @Description: @Date 2021-9-26 */
public class FileUtil {
  /**
   * 读取本地文件，单词表
   *
   * @param url 单词表.txt文件
   * @return 单词集合(去重)
   */
  public static Set<String> readWordList(String fileName) {
    Set<String> list = new HashSet<>();
    try (InputStreamReader isr =
            new InputStreamReader(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName),
                StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr)) {
      String line = "";
      while ((line = br.readLine()) != null) {
        String[] ss = line.split("\t");
        list.add(ss[1]);
      }
    } catch (Exception ignore) {
      return null;
    }
    return list;
  }

  public static void main(String[] args) {
    System.out.println(readWordList("103976个英语单词库.txt").size());
  }
}
