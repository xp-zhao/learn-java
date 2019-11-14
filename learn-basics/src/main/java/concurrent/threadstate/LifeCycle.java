package concurrent.threadstate;

import java.lang.Thread.State;

/**
 * LifeCycle.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class LifeCycle {

  public static void main(String[] args) {
    for (State value : State.values()) {
      System.out.println(value);
    }
  }
}