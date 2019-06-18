package protocol.response;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 加入群聊返回数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class JoinGroupResponsePacket extends Packet {

  private String groupId;

  private boolean success;

  private String reason;

  @Override
  public Byte getCommand() {
    return Command.JOIN_GROUP_RESPONSE;
  }
}