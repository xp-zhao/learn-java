package protocol.request;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 获取群列表请求数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class ListGroupMembersRequestPacket extends Packet {

  private String groupId;

  @Override
  public Byte getCommand() {
    return Command.LIST_GROUP_MEMBERS_REQUEST;
  }
}