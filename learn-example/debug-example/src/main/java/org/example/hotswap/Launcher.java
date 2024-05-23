package org.example.hotswap;

/**
 * @author zhaoxiaoping
 * @date 2024-5-23
 */
public class Launcher {
  public static void main(String[] args) throws InterruptedException {
    if ("JavaAgent".equals(args[0])) {
      JavaAgent.query(1);
    } else if ("LoadAgent".equals(args[0])) {
      new AgentLoader().run(args);
    }
  }
}
