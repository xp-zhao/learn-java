package interview.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-9-26
 **/
public class Example {
  public static void main(String[] args) {
    Integer[] srcArray = new Integer[] {1, 2, 3, 4, 5, 6};
    Integer[] destArray = new Integer[3];
    System.arraycopy(srcArray, 0, destArray, 0, 3);
    System.out.println(Arrays.toString(destArray));
  }
}
