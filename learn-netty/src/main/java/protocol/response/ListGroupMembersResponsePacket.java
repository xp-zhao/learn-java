package protocol.response;

import java.util.List;
import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;
import session.Session;

/**
 * @description: 群聊成员请求返回数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class ListGroupMembersResponsePacket extends Packet {

  private String groupId;

  private List<Session> sessionList;

  @Override
  public Byte getCommand() {
    return Command.LIST_GROUP_MEMBERS_RESPONSE;
  }
}