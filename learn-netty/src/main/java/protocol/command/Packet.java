package protocol.command;

import lombok.Data;

/**
 * @description: 通信过程中 Java 对象的抽象类
 * @author: zhaoxp
 * @create: 2019/05/30
 **/
@Data
public abstract class Packet {

  /**
   * 协议版本
   */
  private Byte version = 1;

  /**
   * 指令
   */
  public abstract Byte getCommand();
}