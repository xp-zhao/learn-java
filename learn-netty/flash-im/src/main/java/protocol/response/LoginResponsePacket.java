package protocol.response;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 登录请求返回数据包
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
@Data
public class LoginResponsePacket extends Packet {

  private String userId;
  private String userName;
  private boolean success;
  private String reason;

  @Override
  public Byte getCommand() {
    return Command.LOGIN_RESPONSE;
  }
}