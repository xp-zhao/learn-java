package client.console;

import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description: 控制台命令管理器
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class ConsoleCommandManager implements ConsoleCommand {

  private Map<String, ConsoleCommand> consoleCommandMap;

  public ConsoleCommandManager() {
    consoleCommandMap = new HashMap<>();
    consoleCommandMap.put("sentToUser", new SendToUserConsoleCommand());
    consoleCommandMap.put("logout", new LogoutConsoleCommand());
    consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
    consoleCommandMap.put("joinGroup", new JoinGroupConsoleCommand());
    consoleCommandMap.put("quitGroup", new QuitGroupConsoleCommand());
    consoleCommandMap.put("listGroupMembers", new ListGroupMembersConsoleCommand());
  }

  @Override
  public void exec(Scanner scanner, Channel channel) {
    // 获取第一个指令
    String command = scanner.next();

    ConsoleCommand consoleCommand = consoleCommandMap.get(command);

    if (consoleCommand != null) {
      consoleCommand.exec(scanner, channel);
    } else {
      System.err.println("无法识别[" + command + "]指令，请重新输入!");
    }
  }
}