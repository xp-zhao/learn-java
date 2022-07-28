package core;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/28
 */
public class Example {
  public static void main(String[] args) {
    if (args == null || new Example() {{Example.main(null);}} == null) {
      System.out.print("a");
    } else {
      System.out.print("b");
    }
  }
}
