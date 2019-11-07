package concurrent.threadsafety.threadlocalfield;

import lombok.Getter;

/**
 * StateHolder.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/07
 **/
@Getter
public class StateHolder {

  private final String state;

  public StateHolder(String state) {
    this.state = state;
  }
}