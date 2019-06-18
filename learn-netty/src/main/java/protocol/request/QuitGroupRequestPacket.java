package protocol.request;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 退出群聊请求数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class QuitGroupRequestPacket extends Packet {

  private String groupId;

  @Override
  public Byte getCommand() {
    return Command.QUIT_GROUP_REQUEST;
  }
}