package client.console;

import io.netty.channel.Channel;
import java.util.Scanner;
import protocol.request.JoinGroupRequestPacket;

/**
 * @description: 加入群聊命令处理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class JoinGroupConsoleCommand implements ConsoleCommand {

  @Override
  public void exec(Scanner scanner, Channel channel) {
    JoinGroupRequestPacket requestPacket = new JoinGroupRequestPacket();

    System.out.print("输入 groupId，加入群聊：");
    String groupId = scanner.next();

    requestPacket.setGroupId(groupId);
    channel.writeAndFlush(requestPacket);
  }
}