package session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户唯一性标识对象
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
@Data
@NoArgsConstructor
public class Session {

  /**
   * 用户唯一标识
   */
  private String userId;
  private String userName;

  public Session(String userId, String userName) {
    this.userId = userId;
    this.userName = userName;
  }

  @Override
  public String toString() {
    return userId + ":" + userName;
  }
}