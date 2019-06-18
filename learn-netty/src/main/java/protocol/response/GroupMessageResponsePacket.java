package protocol.response;

import lombok.Data;
import protocol.command.Command;
import protocol.command.Packet;
import session.Session;

/**
 * @description: 群聊消息发送请求返回数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
@Data
public class GroupMessageResponsePacket extends Packet {

  private String fromGroupId;

  private Session fromUser;

  private String message;

  @Override
  public Byte getCommand() {
    return Command.GROUP_MESSAGE_RESPONSE;
  }
}