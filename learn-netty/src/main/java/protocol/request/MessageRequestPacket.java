package protocol.request;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 客户端发送消息对象
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
@Data
public class MessageRequestPacket extends Packet {

  private String message;

  @Override
  public Byte getCommand() {
    return Command.MESSAGE_REQUEST;
  }
}