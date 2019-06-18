package client.console;

import io.netty.channel.Channel;
import java.util.Scanner;
import protocol.request.MessageRequestPacket;

/**
 * @description: 发送消息命令
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class SendToUserConsoleCommand implements ConsoleCommand {

  @Override
  public void exec(Scanner scanner, Channel channel) {
    System.out.print("发送消息给某个某个用户：");

    String toUserId = scanner.next();
    String message = scanner.next();
    channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
  }
}