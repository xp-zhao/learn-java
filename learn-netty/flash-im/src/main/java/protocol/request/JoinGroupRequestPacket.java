package protocol.request;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 加入群聊请求数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class JoinGroupRequestPacket extends Packet {

  private String groupId;

  @Override
  public Byte getCommand() {
    return Command.JOIN_GROUP_REQUEST;
  }
}