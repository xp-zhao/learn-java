package concurrent.threadlocal;

import lombok.ToString;

/**
 * Content.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
@ToString
public class Content {

  private String userName;

  public Content(String userName) {
    this.userName = userName;
  }
}