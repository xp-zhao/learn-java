package protocol.request;

import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 登出请求数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class LogoutRequestPacket extends Packet {

  @Override
  public Byte getCommand() {
    return Command.LOGOUT_REQUEST;
  }
}