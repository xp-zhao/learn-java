package com.xp.struct.decorator;

/**
 * 用于日志记录的装饰器
 *
 * @author xp-zhao
 * @date 2018/12/13
 */
public class LoggerDecorator implements Command {

  Command cmd;

  public LoggerDecorator(Command cmd) {
    this.cmd = cmd;
  }

  @Override
  public void execute() {
    System.out.println("记录日志开始");
    this.cmd.execute();
    System.out.println("记录日志结束");
  }
}
