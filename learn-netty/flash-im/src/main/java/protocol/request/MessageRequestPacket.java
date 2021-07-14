package protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 客户端发送消息对象
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

  /**
   * 表示要发送给哪个用户
   */
  private String toUserId;
  /**
   * 要发送的消息
   */
  private String message;

  public MessageRequestPacket(String toUserId, String message) {
    this.toUserId = toUserId;
    this.message = message;
  }

  @Override
  public Byte getCommand() {
    return Command.MESSAGE_REQUEST;
  }
}