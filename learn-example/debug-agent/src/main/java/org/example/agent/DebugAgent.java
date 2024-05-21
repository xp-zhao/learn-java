package org.example.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author zhaoxiaoping
 * @date 2024-5-20
 */
public class DebugAgent {
  public static void premain(String agentArgs, Instrumentation instrumentation) {
    System.out.println("DebugAgent.premain() was called.");
    System.out.println("Adding a DebugAgent instance to the JVM.");
    // 注册 transformer
    instrumentation.addTransformer(new DebugTransformer());
  }
}
