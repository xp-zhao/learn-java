package protocol.response;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

import java.util.List;

/**
 * @description: 创建群聊请求返回数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class CreateGroupResponsePacket extends Packet {

  private boolean success;

  private String groupId;

  private List<String> userNameList;

  @Override
  public Byte getCommand() {
    return Command.CREATE_GROUP_RESPONSE;
  }
}