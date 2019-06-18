package protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 群聊消息发送请求数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {

  private String toGroupId;
  private String message;

  public GroupMessageRequestPacket(String toGroupId, String message) {
    this.toGroupId = toGroupId;
    this.message = message;
  }

  @Override
  public Byte getCommand() {
    return Command.GROUP_MESSAGE_REQUEST;
  }
}