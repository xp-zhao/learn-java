package client.console;

import io.netty.channel.Channel;
import java.util.Scanner;
import protocol.request.LoginRequestPacket;

/**
 * @description: 登录请求命令
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class LoginConsoleCommand implements ConsoleCommand {

  @Override
  public void exec(Scanner scanner, Channel channel) {
    LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

    System.out.print("输入用户名登录: ");
    loginRequestPacket.setUsername(scanner.nextLine());
    loginRequestPacket.setPassword("pwd");

    // 发送登录数据包
    channel.writeAndFlush(loginRequestPacket);
    waitForLoginResponse();
  }

  private static void waitForLoginResponse() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}