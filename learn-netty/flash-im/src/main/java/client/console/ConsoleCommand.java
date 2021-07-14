package client.console;

import io.netty.channel.Channel;
import java.util.Scanner;

/**
 * @Description: 控制台命令统一接口
 * @Author: zhaoxiaoping
 * @Date: 2019/6/18
 */
public interface ConsoleCommand {

  /**
   * 执行方法
   */
  void exec(Scanner scanner, Channel channel);
}
