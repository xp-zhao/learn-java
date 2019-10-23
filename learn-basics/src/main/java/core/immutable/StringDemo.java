package core.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * StringDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/23
 **/
public class StringDemo {

  public static void main(String[] args) {
    final String name = "xp";
    String newName = name.replace("x", "p");
    System.out.println(name);
    System.out.println(newName);

    final List<String> strings = new ArrayList<>();
    System.out.println(strings.size());
    strings.add("xp");
    System.out.println(strings.size());
  }
}