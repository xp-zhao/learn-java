package core.system;

import java.io.IOException;
import java.io.PrintStream;

/**
 * SystemExample.java java.lang.System core functionality
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
public class SystemExample {

  public static void main(String[] args) throws IOException {
    System.out.println("some inline message");
    System.setOut(new PrintStream("system.txt"));
    System.out.println("write file");
    System.err.println("some inline error message");
    byte[] name = new byte[1024];
    System.in.read(name, 0, 1024);
    System.out.println(name);
  }
}