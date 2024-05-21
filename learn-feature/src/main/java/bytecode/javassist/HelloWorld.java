package bytecode.javassist;

/**
 * @author zhaoxiaoping
 * @date 2024-5-15
 */
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("hello javassist");
    new HelloWorld().test();
  }

  public HelloWorld() {}

  public void test() {
    System.out.println("test");
  }
}
