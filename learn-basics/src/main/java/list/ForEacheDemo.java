package list;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @Description: foreach 测试
 * @Date 2020/3/30
 **/
public class ForEacheDemo {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,3,4,5,6);
    list.forEach(item -> {
      if (item % 2 == 0) {
        return;
      }
      System.out.println(item);
    });
  }
}
