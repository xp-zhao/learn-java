package pattern.decorator;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class Client {

  public static void main(String[] args) {
    ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
    System.out.println(tree1.decorate());

    ChristmasTree tree2 = new BubbleLights(new Garland(new Garland(new ChristmasTreeImpl())));
    System.out.println(tree2.decorate());
  }
}