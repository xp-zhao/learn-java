package protocol.request;

import java.util.List;
import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 创建群聊请求数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class CreateGroupRequestPacket extends Packet {

  private List<String> userIdList;

  @Override
  public Byte getCommand() {
    return Command.CREATE_GROUP_REQUEST;
  }
}