package client.console;

import io.netty.channel.Channel;
import java.util.Scanner;
import protocol.request.QuitGroupRequestPacket;

/**
 * @description: 退出群聊命令
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class QuitGroupConsoleCommand implements ConsoleCommand {

  @Override
  public void exec(Scanner scanner, Channel channel) {
    QuitGroupRequestPacket requestPacket = new QuitGroupRequestPacket();
    System.out.print("输入 groupId，退出群聊：");
    String groupId = scanner.next();

    requestPacket.setGroupId(groupId);
    channel.writeAndFlush(requestPacket);
  }
}