package protocol.request;

import protocol.command.Command;
import protocol.command.Packet;

/**
 * @description: 心跳检测数据包
 * @author: zhaoxiaoping
 * @create: 2019/06/20
 **/
public class HeartBeatRequestPacket extends Packet {

  @Override
  public Byte getCommand() {
    return Command.HEARTBEAT_REQUEST;
  }
}