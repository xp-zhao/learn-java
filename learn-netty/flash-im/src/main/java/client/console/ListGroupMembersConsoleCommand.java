package client.console;

import io.netty.channel.Channel;
import java.util.Scanner;
import protocol.request.ListGroupMembersRequestPacket;

/**
 * @description: 获取群聊成员列表命令
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class ListGroupMembersConsoleCommand implements ConsoleCommand {

  @Override
  public void exec(Scanner scanner, Channel channel) {
    ListGroupMembersRequestPacket requestPacket = new ListGroupMembersRequestPacket();
    System.out.print("输入 groupId，获取群成员列表：");
    String groupId = scanner.next();

    requestPacket.setGroupId(groupId);
    channel.writeAndFlush(requestPacket);
  }
}