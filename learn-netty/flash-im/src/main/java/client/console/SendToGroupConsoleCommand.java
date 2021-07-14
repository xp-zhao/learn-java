package client.console;

import io.netty.channel.Channel;
import java.util.Scanner;
import protocol.request.GroupMessageRequestPacket;

/**
 * @description: 向群聊中发送消息
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class SendToGroupConsoleCommand implements ConsoleCommand {

  @Override
  public void exec(Scanner scanner, Channel channel) {
    System.out.print("发送消息给某个某个群组：");

    String toGroupId = scanner.next();
    String message = scanner.next();
    channel.writeAndFlush(new GroupMessageRequestPacket(toGroupId, message));
  }
}