package protocol.response;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 登出请求返回数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class LogoutResponsePacket extends Packet {

  private boolean success;

  private String reason;

  @Override
  public Byte getCommand() {
    return Command.LOGOUT_RESPONSE;
  }
}