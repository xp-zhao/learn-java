package protocol.response;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 服务端回复消息对象
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
@Data
public class MessageResponsePacket extends Packet {

  private String fromUserId;
  private String fromUserName;
  private String message;

  @Override
  public Byte getCommand() {
    return Command.MESSAGE_RESPONSE;
  }
}