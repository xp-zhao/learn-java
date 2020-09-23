package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author zhaoxiaoping
 * @Description: 破解密码示例
 * @Date 2020-9-23
 **/
public class CrackExample {

  public static String pwd = "cdaee";
  public static AtomicInteger count = new AtomicInteger(0);

  public static void main(String[] args) {
    ArrayList<String> elements = new ArrayList<>(Arrays.asList("a", "b", "d", "c", "e"));
    crack(elements, new ArrayList<>());
    System.out.println(count.get());
  }

  public static void crack(ArrayList<String> elements, ArrayList<String> result) {
    if (elements.size() == result.size()) {
      count.incrementAndGet();
      String str = result.stream().collect(Collectors.joining());
      System.out.println(str);
      return;
    }
    elements.forEach(item -> {
      ArrayList<String> newResult = (ArrayList<String>) result.clone();
      newResult.add(item);
      crack(elements, newResult);
    });
  }
}
