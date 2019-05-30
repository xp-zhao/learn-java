package protocol.command;

import lombok.Data;

/**
 * @description: 登录请求数据包
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
@Data
public class LoginRequestPacket extends Packet {

  private Integer userId;
  private String username;
  private String password;

  @Override
  public Byte getCommand() {
    return Command.LOGIN_REQUEST;
  }
}