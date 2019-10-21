package classloader;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Class loader in Java
 *
 * @author: zhaoxiaoping
 */
public class ClassLoaderDemo {

  public static void main(String[] args) {
    System.out.println("Classloader of this class: " + ClassLoaderDemo.class.getClassLoader());
    System.out.println("Classloader of Logging: " + Logger.class.getClassLoader());
    System.out.println("Classloader of ArrayList: " + ArrayList.class.getClassLoader());
  }
}
