package core.init;
/**
 * @author zhaoxiaoping
 * @date 2023-8-4
 */
public class Animal {
  /** 8. 执行属性初始化 */
  private int i = 9;

  protected int j;

  /** 7. 调用父类的构造方法，创建默认的属性和方法 */
  public Animal() {
    /** 9. 执行构成函数的内容，结束后返回子类的构造函数 */
    System.out.println("i = " + i + ", j = " + j);
    j = 39;
  }

  /** 2. 初始化父类的静态变量和方法 */
  private static int x1 = print("static Animal.x1 initialized");

  static int print(String s) {
    System.out.println(s);
    return 47;
  }
}
