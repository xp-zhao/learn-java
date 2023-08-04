package core.init;
/**
 * @author zhaoxiaoping
 * @date 2023-8-4
 */
public class Dog extends Animal {
  /** 10. 初始化子类的默认属性和方法 */
  private int k = print("Dog.k initialized");

  /** 6. 创建对象（分配存储空间，创建默认的属性和方法），遇到隐式或显式的 super() 方法，跳转到父类的构造函数 */
  public Dog() {
    /** 11. 属性初始化之后，执行构造函数的内容 */
    System.out.println("k = " + k);
    System.out.println("j = " + j);
  }

  /** 3. 初始化子类静态属性和方法 */
  private static int x2 = print("static Dog.x2 initialized");

  /** 1. 执行执行静态 main 方法，首先加载 Dog.class, 加载过程中发现继承了 Animal 所以也要加载 Animal.class */
  public static void main(String[] args) {
    /** 4. 父类和子类的静态属性初始化完成之后，执行 main 方法 */
    System.out.println("Dog constructor");
    /** 5. 遇到 new 关键字，调用 Dog 对象的构造方法 */
    Dog dog = new Dog();
    /** 12. 执行 main 函数剩下的内容 */
    System.out.println("Main End");
  }
}
