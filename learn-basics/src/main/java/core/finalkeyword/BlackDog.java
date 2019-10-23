package core.finalkeyword;

/**
 * BlackDog.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/23
 **/
public class BlackDog extends Dog {

  public static void main(String[] args) {
    final Cat cat = new Cat();
    cat.setWeight(5);
    System.out.println(cat.getWeight());
  }
}