package protocol.request;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 登录请求数据包
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
@Data
public class LoginRequestPacket extends Packet {

  private String userId;
  private String username;
  private String password;

  @Override
  public Byte getCommand() {
    return Command.LOGIN_REQUEST;
  }
}