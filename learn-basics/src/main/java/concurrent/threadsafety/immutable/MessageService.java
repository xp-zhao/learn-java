package concurrent.threadsafety.immutable;

import lombok.Getter;

/**
 * MessageService.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/07
 **/
@Getter
public class MessageService {

  private final String message;

  public MessageService(String message) {
    this.message = message;
  }
}