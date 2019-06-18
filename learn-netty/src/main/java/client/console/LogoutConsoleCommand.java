package client.console;

import io.netty.channel.Channel;
import java.util.Scanner;
import protocol.request.LogoutRequestPacket;

/**
 * @description: 登出请求命令
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class LogoutConsoleCommand implements ConsoleCommand {

  @Override
  public void exec(Scanner scanner, Channel channel) {
    LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
    channel.writeAndFlush(logoutRequestPacket);
  }
}